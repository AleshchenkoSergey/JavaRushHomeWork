package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки ввода-вывода
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileInputStream inputStream1 = new FileInputStream(fileName1);
        FileOutputStream outputStream2 = new FileOutputStream(fileName2);
        FileOutputStream outputStream3 = new FileOutputStream(fileName3);

        byte[] buffer1 = new byte[inputStream1.available()];


        while (inputStream1.available() > 0) {
            int count = inputStream1.read(buffer1);
            int part1 = (count / 2) + (count % 2);
            int part2 = count / 2;
            outputStream2.write(buffer1, 0, part1);
            outputStream3.write(buffer1, part1, part2);
        }
        reader.close();
        inputStream1.close();
        outputStream2.close();
        outputStream3.close();

    }
}
