package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть закрыть файл и поток.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException, FileNotFoundException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        InputStream inStream = new FileInputStream(reader.readLine());
        //OutputStream outStream = new FileOutputStream("d:/result.txt");

        while(inStream.available() > 0) {

            System.out.print((char)inStream.read());
        }


        inStream.close();
        //outStream.close();
        reader.close();

    }
}
