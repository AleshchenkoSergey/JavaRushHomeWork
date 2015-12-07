package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = new ArrayList<Integer>();
        Scanner in = new Scanner(new File(reader.readLine()));

        while (in.hasNextInt()) {                           // Заполняем List числами, прочитанными из файла
                numbers.add(in.nextInt());
        }


//        for (int i = 0; i < numbers.size(); i++) {          // Удаляем все нечетные числа
//            if ((numbers.get(i) % 2) != 0) {
//                numbers.remove(i);
//            }
//        }


        for (int i = 0; i < numbers.size();) {          // Удаляем все нечетные числа
            if ((numbers.get(i) % 2) != 0) {
                numbers.remove(i);
            } else {
                i++;
            }
        }


        for (int i = 0; i < numbers.size(); i++) {           // Сортировка по возрастанию
            for (int j = i + 1; j < numbers.size(); j++) {
                if(numbers.get(j) < numbers.get(i)) {
                    int temp = numbers.get(i);
                    numbers.set(i, numbers.get(j));
                    numbers.set(j, temp);
                }
            }
        }


        for (int i = 0; i < numbers.size(); i++) {           // Вывод результата
            System.out.println(numbers.get(i));
        }

        in.close();
        reader.close();

    }
}
