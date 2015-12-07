package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int A[] = new int[5];
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));



        for (int i = 0; i <=4 ; i++) {
            String s = reader.readLine();
            int n = Integer.parseInt(s);
            A[i] = n;
        }


        int i;

        for (int j = 1; j <=4 ; j++) {

            int key = A[j];

            i = j - 1;

            while (i > -1 && A[i] > key) {
                A[i+1] = A[i];
                i = i - 1;
            }

            A[i + 1] = key;
        }

        for (int k = 0; k <=4 ; k++) {
            System.out.print(A[k] + " ");
        }
    }
}
