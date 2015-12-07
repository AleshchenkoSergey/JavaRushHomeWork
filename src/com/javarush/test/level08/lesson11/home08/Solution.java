package com.javarush.test.level08.lesson11.home08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Пять наибольших чисел
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Вывести пять наибольших чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[19]);
        System.out.println(array[18]);
        System.out.println(array[17]);
        System.out.println(array[16]);
        System.out.println(array[15]);
    }

    public static void sort(int[] array)
    {
        //Напишите тут ваш код
        int key;
        int i;

        for (int j = 2; j < array.length; j++) {
            key = array[j];
            i = j-1;
            while ((i > 0) & (array[i] > key)) {
                array[i+1] = array[i];
                i = i - 1;
            }
            array[i+1] = key;
        }

    }
}
