package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String sNumber1 = reader.readLine();
        String sNumber2 = reader.readLine();

        int nNumber1 = Integer.parseInt(sNumber1);
        int nNumber2 = Integer.parseInt(sNumber2);

        if (nNumber1 <= nNumber2)
            System.out.println(nNumber1);
        else
            System.out.println(nNumber2);
        /* данные для тестирования:
        введите 1 и 2, минимум =  1
        введите 2 и 1, минимум =  1
        введите 1 и 1, минимум =  1
        введите -1 и -2, минимум =  -2
         */
    }
}