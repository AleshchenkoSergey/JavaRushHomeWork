package com.javarush.test.level08.lesson11.home03;

import java.util.HashMap;
import java.util.Map;

/* Люди с одинаковыми именами и/или фамилиями
1. Создать словарь Map (<String, String>) и добавить туда 10 человек в виде «Фамилия»-«Имя».
2. Пусть среди этих 10 человек есть люди с одинаковыми именами.
3. Пусть среди этих 10 человек есть люди с одинаковыми фамилиями.
4. Вывести содержимое Map на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList()
    {
        //Напишите тут ваш код
        Map<String, String> people = new HashMap<String, String>();
        people.put("Имя1", "Фамилия1");
        people.put("Имя1", "Фамилия2");
        people.put("Имя2", "Фамилия3");
        people.put("Имя3", "Фамилия3");
        people.put("Имя4", "Фамилия4");
        people.put("Имя5", "Фамилия5");
        people.put("Имя6", "Фамилия6");
        people.put("Имя7", "Фамилия7");
        people.put("Имя8", "Фамилия8");
        people.put("Имя9", "Фамилия9");
        return people;
    }

    public static void printPeopleList(Map<String, String> map)
    {
        for (Map.Entry<String, String> s : map.entrySet())
        {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }

}
