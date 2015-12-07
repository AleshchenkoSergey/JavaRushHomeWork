package com.javarush.test.level22.lesson09.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String fileName = br.readLine();
        br = new BufferedReader(new FileReader(fileName));

        String str;
        String tempString = "";

        while ((str = br.readLine()) != null)
        {
            tempString += str;
        }

        br.close();


        StringBuilder result = getLine(tempString.split(" "));
        System.out.println(result.toString());



    }

    public static StringBuilder getLine(String... words) {
        List<String> straightOrder1 = new ArrayList<>();
        List<String> straightOrder2 = new ArrayList<>();

        if (words == null || words.length == 0)
            return new StringBuilder();
        if (words[0].equals(""))
            return new StringBuilder(words[0]);

        String[] wordsArr = words[0].split(" ");

        for (int i = 0; i < wordsArr.length; i++) {
            straightOrder1.add(wordsArr[i]);
        }

        for (int i = 0; i < wordsArr.length; i++) {
            straightOrder2.add(wordsArr[i]);
        }

        String result = "";


        for (int i = 0; i < straightOrder1.size(); i++) {

            for (int j = 0; j < straightOrder2.size(); j++) {

                if (straightOrder1.get(i).charAt(straightOrder1.get(i).length() - 1) == straightOrder2.get(j).charAt(0)) {
                    result = result + " " + straightOrder1 + " " + straightOrder2;
                }


            }
        }
        StringBuilder resultString = new StringBuilder(result);

        return resultString;
    }
}
