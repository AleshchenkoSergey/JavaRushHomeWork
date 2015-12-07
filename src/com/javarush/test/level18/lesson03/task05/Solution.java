package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();

        while(inputStream.available() > 0) {
            list.add(inputStream.read());
        }



        for (int i = 0; i < list.size(); i++) {
            int key = list.get(i);
            for (int j = i + 1; j < list.size();) {
                if (list.get(j).equals(key)) {
                    list.remove(j);
                } else {
                    j++;
                }
            }
        }


        Collections.sort(list);
        for (int temp : list) {
            System.out.print(temp + " ");
        }

        reader.close();
        inputStream.close();
    }
}
