package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть поток

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader reader = new BufferedReader(new FileReader(br.readLine()));

        String line;
        List<String> sourceLines = new ArrayList<String>();


        while ((line = reader.readLine()) != null)
            sourceLines.add(line);

        for (int i = 0; i < sourceLines.size(); i++) {
            String sourceLine = sourceLines.get(i);
            char[] sourceCharLine = sourceLine.toCharArray();
            for (int j = 0; j < sourceCharLine.length / 2; j++) {
                char temp = sourceCharLine[j];
                sourceCharLine[j] = sourceCharLine[sourceCharLine.length - j - 1];
                sourceCharLine[sourceCharLine.length - j - 1] = temp;
            }
            System.out.println(sourceCharLine);
        }

        br.close();
        reader.close();
    }
}
