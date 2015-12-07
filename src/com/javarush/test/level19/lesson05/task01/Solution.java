package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();

        FileReader reader = new FileReader(fileName1);
        FileWriter writer = new FileWriter(fileName2);

        int index = 0;

        while (reader.ready()) {
            int data = reader.read();
            index += 1;
            if (index % 2 == 0) {
                writer.write(data);
            }
        }

        reader.close();
        writer.close();
    }
}
