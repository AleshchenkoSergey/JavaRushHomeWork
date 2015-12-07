package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double maximum = Double.NEGATIVE_INFINITY;


        String sN = reader.readLine();
        int N = Integer.parseInt(sN);

        for (int i = 0; i <= N-1; i++) {

            String string = reader.readLine();
            int n = Integer.parseInt(string);

            if (n >= maximum) maximum = n;
        }


        System.out.println((int)maximum);
    }
}
