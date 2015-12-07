package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static void main(String[] args) {

       HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);

        for (Map.Entry<String, Date> pair : map.entrySet()) {
            String key = pair.getKey();
            Date value = pair.getValue();
            System.out.println(key + " : " + value);
        }
    }


    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUNE 1 1980"));
        map.put("Йталлоне", new Date("AUGUST 1 1980"));
        map.put("Цталлоне", new Date("DECEMBER 1 1980"));
        map.put("Уталлоне", new Date("JUNE 1 1980"));
        map.put("Кталлоне", new Date("JUNE 1 1980"));
        map.put("Еталлоне", new Date("JUNE 1 1980"));
        map.put("Фталлоне", new Date("JUNE 1 1980"));
        map.put("Ыталлоне", new Date("JUNE 1 1980"));
        map.put("Вталлоне", new Date("JUNE 1 1980"));
        map.put("Аталлоне", new Date("JUNE 1 1980"));


        //Напишите тут ваш код
        return map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //Напишите тут ваш код
        Iterator<Map.Entry<String,Date>> iterator = map.entrySet().iterator();


        while (iterator.hasNext()) {


            Map.Entry<String,Date> pair = iterator.next();
            Date value = pair.getValue();


            if (value.getMonth() > 4 && value.getMonth() < 8)
                iterator.remove();
        }


        //System.out.println(today.getMonth());



    }
}
