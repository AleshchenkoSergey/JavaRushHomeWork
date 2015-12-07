package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        ArrayList<Integer> list = new ArrayList<Integer>();

        FileInputStream inputStream1 = new FileInputStream(fileName1);
        FileInputStream inputStream2 = new FileInputStream(fileName2);

        while (inputStream2.available() > 0) {
            list.add(inputStream2.read());
        }


        while (inputStream1.available() > 0) {
            list.add(inputStream1.read());
        }



        FileOutputStream outputStream = new FileOutputStream(fileName1);

        for (int i = 0; i < list.size(); i++) {
            outputStream.write(list.get(i));
        }


        reader.close();
        inputStream1.close();
        inputStream2.close();
        outputStream.close();
    }
}
