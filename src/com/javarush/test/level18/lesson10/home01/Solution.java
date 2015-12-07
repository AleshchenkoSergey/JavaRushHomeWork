package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {


        String fileName = args[0];
        FileInputStream inputStream = new FileInputStream(fileName);
        int count = 0;

        char a;
        while (inputStream.available() > 0) {
            int data = inputStream.read();

            a = (char) data;
            if ((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z')) count++;
        }

        System.out.println(count);
    }
}
