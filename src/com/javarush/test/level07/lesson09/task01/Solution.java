package com.javarush.test.level07.lesson09.task01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка  с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution
{
    public static void main(String[] args) throws Exception {
        //add your code here
        Reader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);

        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> listDev3 = new ArrayList<Integer>();
        ArrayList<Integer> listDev2 = new ArrayList<Integer>();
        ArrayList<Integer> listOthers = new ArrayList<Integer>();

        for (int i = 0; i < 20; i++) {
            String s = reader.readLine();
            list.add(Integer.parseInt(s));
        }


        for (int i = 0; i < list.size(); i++) {
            Integer x = list.get(i);
            if (x % 3 == 0 && x % 2 == 0) {
                listDev3.add(x);
                listDev2.add(x);
            } else {
                if (x % 3 == 0) {
                    listDev3.add(x);
                } else {
                    if (x % 2 == 0) {
                        listDev2.add(x);
                    } else {
                        listOthers.add(x);
                    }
                }


            }
        }

            printList(listDev3);

            printList(listDev2);

            printList(listOthers);


    }

    public static void printList(List<Integer> list) {
        //add your code here
        for (Integer x : list) {
            System.out.println(x);
        }
    }
}
