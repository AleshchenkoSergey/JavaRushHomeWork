package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;

        while (!("exit").equals(fileName = reader.readLine())) {
            ReadThread thread = new ReadThread(fileName);
            thread.start();
            thread.join();
        }
        Iterator<Map.Entry<String, Integer>> iterator = resultMap.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String, Integer> pair = iterator.next();
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }

        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                FileInputStream inputStream = new FileInputStream(this.fileName);
                ArrayList<Integer> bytes = new ArrayList<>();

                int maxCount = Integer.MIN_VALUE;
                int searchByte = 0;

                while (inputStream.available() > 0) {
                    bytes.add(inputStream.read());
                }

                for (int i = 0; i < bytes.size() - 1; i++) {
                    int count = 1;
                    int compareByte = bytes.get(i);
                    for (int j = i + 1; j < bytes.size(); j++) {
                        if (compareByte == bytes.get(j)) {
                            count++;
                        }
                    }

                    if (count > maxCount) {
                        maxCount = count;
                        searchByte = bytes.get(i);

                    }
                }

                resultMap.put(fileName, searchByte);
                inputStream.close();

            } catch (FileNotFoundException e) {
                return;
            } catch (IOException e) {
                return;
            }
        }
    }
}
