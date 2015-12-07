package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];

        FileInputStream inputStream = new FileInputStream(fileName);

        int symbolCount = 0;
        int spaceCount = 0;

        while(inputStream.available() > 0) {
            symbolCount++;
            int data = inputStream.read();


            if (data == (int)' ') {
                spaceCount++;
            }


        }

        double dCount = ((double)spaceCount*100)/symbolCount;
        System.out.println(round(dCount, 2));
    }

    public static double round(double value, int scale) {
        return Math.round(value * Math.pow(10, scale)) / Math.pow(10, scale);
    }
}
