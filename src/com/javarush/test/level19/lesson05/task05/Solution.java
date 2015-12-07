package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки ввода-вывода.
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        FileReader fr = new FileReader(br.readLine());
        FileWriter fw = new FileWriter(br.readLine());

        while (fr.ready()) {
            int data = fr.read();
            if (!(data >= 33 && data <= 47) && !(data >= 58 && data <= 64) && !(data >= 91 && data <= 96) && !(data >= 123 && data <= 127)) {
                fw.write(data);
            }
        }

        fr.close();
        fw.close();
        br.close();

    }
}
