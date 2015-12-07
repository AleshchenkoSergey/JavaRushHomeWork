package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();
    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(br.readLine());

        BufferedReader reader = new BufferedReader(fileReader);
        String line;

        List<String> sourceLines = new ArrayList<String>();

        while ((line = reader.readLine()) != null)
            sourceLines.add(line);

        for (int i = 0; i < sourceLines.size(); i++) {
            String[] splitedString = sourceLines.get(i).split(" ");
            Map<String, Integer> resultMap = new HashMap<>();

            for (String temp : splitedString) {
                if (words.contains(temp))
                    resultMap.put(temp, 1);
            }

            if (resultMap.size() == 2)
                System.out.println(sourceLines.get(i));
        }



        br.close();
        fileReader.close();
        reader.close();
    }
}
