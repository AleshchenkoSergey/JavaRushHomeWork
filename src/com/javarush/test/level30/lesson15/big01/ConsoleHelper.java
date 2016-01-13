package com.javarush.test.level30.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sergey on 28.12.15.
 */
public class ConsoleHelper {
    private static BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String readString = null;

        while (true) {
            try {
                readString = bufferedReader.readLine();
                break;
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }

        return readString;
    }

    public static int readInt() {
        String readString = null;
        int readInt = 0;

        while (true) {
            readString = readString();
            try {
                readInt = Integer.parseInt(readString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }

        return readInt;
    }
}
