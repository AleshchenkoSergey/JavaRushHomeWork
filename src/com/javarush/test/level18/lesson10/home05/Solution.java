package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


            BufferedReader brf = new BufferedReader(new FileReader(br.readLine()));
            BufferedWriter bwf = new BufferedWriter(new FileWriter(br.readLine()));

            String s;
            while ((s = brf.readLine()) != null)
            {
                brf.read();
                String[] tmp = s.split(" ");

                for (String item : tmp)
                {
                    long num = Math.round(Double.parseDouble(item));
                    bwf.write(String.valueOf(num) + " ");
                }
            }

            brf.close();
            bwf.flush();
            bwf.close();




    }
}
