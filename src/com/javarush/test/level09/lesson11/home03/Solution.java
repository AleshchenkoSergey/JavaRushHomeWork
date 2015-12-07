package com.javarush.test.level09.lesson11.home03;

/* Метод в try..catch
Вводить с клавиатуры числа. Код по чтению чисел с клавиатуры вынести в отдельный метод readData.
Обернуть все тело (весь код внутри readData, кроме объявления списка, где будут храниться числа) этого метода в try..catch.
Если пользователь ввёл какой-то текст, вместо ввода числа, то метод должен перехватить исключение и
вывести на экран все введенные числа в качестве результата.
Числа выводить с новой строки сохраняя порядок ввода
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //add your code here
        List<Integer> list = new ArrayList<Integer>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String s = reader.readLine();
                list.add(Integer.parseInt(s));
            }
        }
        catch (Exception e) {
            for (int temp : list) {
                System.out.println(temp);
            }
        }
    }
}