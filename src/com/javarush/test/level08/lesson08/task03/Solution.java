package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //Напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Фамилия1", "Имя1");
        map.put("Фамилия1", "Имя1");
        map.put("Фамилия1", "Имя1");
        map.put("Фамилия1", "Имя1");
        map.put("Фамилия5", "Имя5");
        map.put("Фамилия6", "Имя6");
        map.put("Фамилия7", "Имя7");
        map.put("Фамилия8", "Имя8");
        map.put("Фамилия9", "Имя9");
        map.put("Фамилия10", "Имя10");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //Напишите тут ваш код
        int count = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        for (Map.Entry<String,String> pair : map.entrySet()) {
            if (pair.getValue().equals(name)) {count++;}
        }

        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        //Напишите тут ваш код
        int count = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        for (Map.Entry<String,String> pair : map.entrySet()) {
            if (pair.getKey().equals(familiya)) {count++;}
        }
        return count;
    }

    public static void main(String[] args) {

        HashMap<String, String> map = createMap();


        System.out.println(getCountTheSameFirstName(map, "Имя1"));
        System.out.println(getCountTheSameLastName(map, "Фамилия1"));
    }
}
