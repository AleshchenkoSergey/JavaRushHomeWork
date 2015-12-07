package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        List<String> sourceLines = new ArrayList<String>();

        while ((line = reader.readLine()) != null) {   // Считываем файл построчно, записываем строки в sourceLines
            sourceLines.add(line);
        }

        Map<String, Double> resultMap = new TreeMap<>();    // Карта, в которой будет храниться результат


        for (int i = 0; i < sourceLines.size(); i++) {  // Алгоритм по суммированию зарплат у людей с одинаковой фамилией

            String[] splitLines = sourceLines.get(i).split(" ");

            if (!resultMap.containsKey(splitLines[0])) {
                resultMap.put(splitLines[0], Double.parseDouble(splitLines[1]));
            } else {
                Double value = resultMap.get(splitLines[0]);
                value = value + Double.parseDouble(splitLines[1]);
                resultMap.put(splitLines[0], value);
            }

        }



        for (Map.Entry<String, Double> temp : resultMap.entrySet()) {   // Выводим результат в консоль
            System.out.println(temp.getKey() + " " + temp.getValue());
        }


        reader.close();
        fileReader.close();


    }
}
