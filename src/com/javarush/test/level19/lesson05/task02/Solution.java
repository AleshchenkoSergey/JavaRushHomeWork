package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileReader fileReader = new FileReader(fileName);
        ArrayList<Integer> arrayList = new ArrayList<>();

        int count = 0;
        String s = "";

        while (fileReader.ready()) {
            s += (char)fileReader.read();
        }

        s = s.replaceAll(" ", ",");
        s = s.replaceAll("\\p{Cntrl}", ",");



        String[] sArr = s.split("\\p{P}");


        for (String k : sArr) {
            if (k.equals("world"))
                count++;
        }
        System.out.println(count);



        reader.close();
        fileReader.close();
    }
}
