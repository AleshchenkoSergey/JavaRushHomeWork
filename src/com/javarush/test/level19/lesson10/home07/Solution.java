package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);

        BufferedWriter writer = new BufferedWriter (new FileWriter(args[1]));
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        List<String> sourceLines = new ArrayList<String>();

        while ((line = reader.readLine()) != null)
            sourceLines.add(line);

        String temp = "";
        String result = "";

        for (int i = 0; i < sourceLines.size(); i++) {
            String[] splitedWords = sourceLines.get(i).split(" ");
            for (int j = 0; j < splitedWords.length; j++) {

                if (splitedWords[j].length() > 6) {
                    temp = temp + splitedWords[j] + ",";
                }
            }
            result = result + temp;
            temp = "";
        }

        if (result.substring(result.length() - 1, result.length()).equals(",")) {
            result = result.substring(0, result.length() - 1);
        }


        writer.write(result);

        fileReader.close();
        reader.close();
        writer.close();
    }
}
