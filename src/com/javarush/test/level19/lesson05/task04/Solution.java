package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        FileReader fr = new FileReader(br.readLine());
        FileWriter fw = new FileWriter(br.readLine());

        while (fr.ready()) {
            int data = fr.read();
            if (data == (int)'.') {
                data = (int)'!';
            }
            fw.write(data);
        }

        fr.close();
        fw.close();
        br.close();
    }
}


