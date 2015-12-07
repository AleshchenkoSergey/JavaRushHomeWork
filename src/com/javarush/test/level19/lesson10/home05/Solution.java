package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);

        BufferedReader reader = new BufferedReader(fileReader);
        String line;

        List<String> sourceLines = new ArrayList<String>();

        while ((line = reader.readLine()) != null)
            sourceLines.add(line);

        for (int i = 0; i < sourceLines.size(); i++) {
            String[] splitedWords = sourceLines.get(i).split(" ");

            for (int j = 0; j < splitedWords.length; j++) {
                if (!splitedWords[j].matches("^\\D*$")) {
                    fileWriter.write(splitedWords[j] + " ");
                }
            }
        }

        fileReader.close();
        fileWriter.close();
        reader.close();
    }
}
