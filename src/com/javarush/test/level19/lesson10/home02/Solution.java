package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
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

        Map<String, Double> resultMap = new HashMap<>();    // Карта, в которой будет храниться результат


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

        List entryList = new ArrayList(resultMap.entrySet());
        Collections.sort(entryList, new Comparator() {

            public int compare(Object o1, Object o2) {

                Map.Entry e1 = (Map.Entry) o1;
                Map.Entry e2 = (Map.Entry) o2;
                Comparable c1 = (Comparable) e1.getValue();
                Comparable c2 = (Comparable) e2.getValue();
                return c1.compareTo(c2);
            }
        });

        List<String> names = new ArrayList<>();
        List<String> moneys = new ArrayList<>();
        List<String> stringNames = new ArrayList<>();
        double maxMoney = Double.MIN_VALUE;

        for (int i = 0; i < entryList.size(); i++) {
            String tempString = entryList.get(i).toString();
            stringNames.add(tempString);

            String[] splitString = tempString.split("=");
            names.add(splitString[0]);
            moneys.add(splitString[1]);
        }

        for (int i = 0; i < moneys.size(); i++) {
            if (Double.parseDouble(moneys.get(i)) > maxMoney) {
                maxMoney = Double.parseDouble(moneys.get(i));
            }
        }


        for (int i = 0; i < stringNames.size(); i++) {
            if (stringNames.get(i).contains(Double.toString(maxMoney))) {

                String[] splitString = stringNames.get(i).split("=");
                System.out.println(splitString[0]);
            }
        }


        reader.close();
        fileReader.close();
    }
}
