package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String URL = reader.readLine();
        String[] dividedOnTwo = URL.split("\\?");
        List<String> list = new ArrayList<>();


        String[] dividedOnParameters = dividedOnTwo[1].split("&");
        String[] temp = null;
        Map<String, String> map = new HashMap<String, String>();


        for (int i = 0; i < dividedOnParameters.length; i++) {
            temp = dividedOnParameters[i].split("=");

            System.out.print(temp[0] + " ");

            if (temp[0].equals("obj")) {
                list.add(temp[1]);
            }
        }

        System.out.println("");

        for (int i = 0; i < list.size(); i++) {
            try {
                alert(Double.parseDouble(list.get(i)));
            } catch (Exception e) {
                alert(list.get(i));
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
