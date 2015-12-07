package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileOutputStream outputStream1 = new FileOutputStream(fileName1);
        FileInputStream inputStream2 = new FileInputStream(fileName2);
        FileInputStream inputStream3 = new FileInputStream(fileName3);

        while (inputStream2.available() > 0) {
            int data = inputStream2.read();
            outputStream1.write(data);
        }

        while (inputStream3.available() > 0) {
            int data = inputStream3.read();
            outputStream1.write(data);
        }
        reader.close();
        outputStream1.close();
        inputStream2.close();
        inputStream3.close();
    }
}
