package com.javarush.test.level07.lesson06.task01;

/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код

        //Напишите тут ваш код


        ArrayList<String> list = new ArrayList<String>();


        list.add("sdada");
        list.add("asdw");
        list.add("sqweq");
        list.add("scz");
        list.add("q");

        System.out.println(list.size());

        for (int j = 0; j < list.size(); j++) {
            System.out.println(list.get(j));
        }

        }

}

