package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        if (args[0].equals("-c"))
            create(args);
        if (args[0].equals("-u"))
            update(args);
        if (args[0].equals("-d"))
            delete(args);
        if (args[0].equals("-i"))
            info(args);
    }

    public synchronized static void create(String[] strings) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        for (int i = 3; i < strings.length; i += 3) {
            Person person;

            if (strings[i - 1].equals("м")) {
                person = Person.createMale(strings[i - 2], format.parse(strings[i]));
            } else {
                person = Person.createFemale(strings[i - 2], format.parse(strings[i]));
            }

            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        }

    }

    public synchronized static void update(String[] strings) throws ParseException {
        for (int i = 4; i < strings.length; i += 4) {
            int id = Integer.parseInt(strings[i - 3]);
            Person person = allPeople.get(id);
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

            if (strings[i - 1].equals("м")) {
                person.setSex(Sex.MALE);
            } else {
                person.setSex(Sex.FEMALE);
            }

            person.setName(strings[i - 2]);
            person.setBirthDay(format.parse(strings[i]));
            allPeople.set(id, person);
        }
    }


    public synchronized static void delete(String[] strings) {
        for (int i = 0; i < strings.length - 1; i++) {
            int id = Integer.parseInt(strings[i + 1]);
            Person person = allPeople.get(id);
            person.setBirthDay(null);
            person.setSex(null);
            person.setName(null);
        }
    }

    public synchronized static void info(String[] strings) {
        for (int i = 0; i < strings.length - 1; i++) {
            int id = Integer.parseInt(strings[i + 1]);
            Person person = allPeople.get(id);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

            if (person.getSex().equals(Sex.MALE)) {
                System.out.println(person.getName() + " " + "м" + " " + dateFormat.format(person.getBirthDay()));
            } else {
                System.out.println(person.getName() + " " + "ж" + " " + dateFormat.format(person.getBirthDay()));
            }

        }
    }
}

