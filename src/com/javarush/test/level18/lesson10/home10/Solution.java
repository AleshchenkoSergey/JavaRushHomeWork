package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        List<String> list = new ArrayList<>();


        while (true) {
            s = reader.readLine();
            if ("end".equals(s)) break;
            if (!list.contains(s)) list.add(s);
        }

        String[] temp = list.get(0).split("\\.");

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(temp[0]);
        stringBuilder.append(".");
        stringBuilder.append(temp[1]);

        String fileOutName = stringBuilder.toString();
        FileOutputStream outputStream = new FileOutputStream(fileOutName);
        FileOutputStream writer = new FileOutputStream(stringBuilder.toString());

        List<Integer> parts= new ArrayList<Integer>();

        for (int i = 0; i < list.size(); i++)
        {
            temp = list.get(i).split("\\.");
            parts.add(Integer.parseInt(temp[temp.length - 1].substring(4)));
        }

        Collections.sort(parts);


        for (int i = 0; i < parts.size(); i++)
        {
            s = stringBuilder.toString()+ "." +"part"+parts.get(i);
            list.set(i, s);
        }


        for (String t : list)
        {
            FileInputStream b = new FileInputStream(t);
            byte[] buffer = new byte[b.available()];
            while(b.available()>0){
                int count = b.read(buffer);
                writer.write(buffer, 0, count);
            }
            b.close();
        }
        writer.close();
        reader.close();


    }
}
