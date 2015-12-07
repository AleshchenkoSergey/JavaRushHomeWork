package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream(args[0]);

        ArrayList<Character> letters = new ArrayList<Character>();
        Map<Character, Integer>  lettersAndCount = new LinkedHashMap<Character, Integer>();
        int count = 1;

        while (inputStream.available() > 0) {
            letters.add((char) inputStream.read());
        }

        for (int i = 0; i < letters.size() - 1; i++) {
            for (int j = i + 1; j < letters.size(); j++) {
                if (letters.get(j) < letters.get(i)) {
                    char temp = letters.get(j);
                    letters.set(j, letters.get(i));
                    letters.set(i, temp);
                }
            }
        }


        for (int i = 0; i < letters.size(); i++) {
                for (int j = i + 1; j < letters.size(); ) {
                    if (letters.get(i) == letters.get(j)) {
                        count++;
                        letters.remove(j);
                    } else {
                        j++;
                    }
                }

            lettersAndCount.put(letters.get(i), count);
            count = 1;
        }


        Set<Map.Entry<Character, Integer>> pair = lettersAndCount.entrySet();

        for (Map.Entry<Character, Integer> set : pair) {
            System.out.println(set.getKey() + " " + set.getValue());
        }


        inputStream.close();

    }
}
