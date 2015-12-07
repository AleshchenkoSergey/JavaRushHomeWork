package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        List<String> sourceLines = new ArrayList<String>();

        Calendar birthdayCalendar = new GregorianCalendar();

        while ((line = reader.readLine()) != null) {
            sourceLines.add(line);
        }


        for (int i = 0; i < sourceLines.size(); i++) {
            String[] splitLines = sourceLines.get(i).split(" ");

            String fullName = "";

            for (int j = 0; j < splitLines.length; j++) {

                try {

                    int date = Integer.parseInt(splitLines[j]);
                    int month = Integer.parseInt(splitLines[j + 1]);
                    int year = Integer.parseInt(splitLines[j + 2]);

                    birthdayCalendar.set(year,month-1,date);

                    break;

                } catch (Exception e) {
                    fullName = fullName + splitLines[j] + " ";
                }
            }

            fullName = fullName.substring(0, fullName.length() - 1);


            PEOPLE.add(new Person(fullName, birthdayCalendar.getTime()));


        }


        fileReader.close();
        reader.close();

    }

}
