package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байты, которые встречаются в файле меньше всего раз.
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 1;

        while(inputStream.available() > 0) {
            list1.add(inputStream.read());
        }

        for (int i = 0; i < list1.size(); i++) {
            int key = list1.get(i);

            for (int j = i + 1; j < list1.size();) {
                if (list1.get(j).equals(key)) {
                    count++;
                    list1.remove(j);
                } else {
                    j++;
                }
            }
            map.put(key, count);
            list2.add(count);
            count = 1;
        }

        Object[] a = list2.toArray();
        Arrays.sort(a);


        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

        for (int i = 0; i < map.size(); i++) {

            Map.Entry<Integer, Integer> pair = iterator.next();
            if (a[0].equals(pair.getValue())){

                System.out.print(pair.getKey() + " ");

            }
        }

        reader.close();
        inputStream.close();
    }
}
