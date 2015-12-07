package com.javarush.test.level07.lesson12.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        //Напишите тут ваш код
        String sN = reader.readLine();
        String sM = reader.readLine();

        int N = Integer.parseInt(sN);
        int M = Integer.parseInt(sM);

        for (int i = 0; i < N; i++) {
            list.add(reader.readLine());
        }

        for (int i = 0; i < M; i++) {
            list.add(list.get(i));
        }

        while (M > 0) {
            list.remove(0);
            M--;
        }

        for (String x : list) {
            System.out.println(x);
        }


    }
}
