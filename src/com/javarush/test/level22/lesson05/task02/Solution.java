package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tfvfvf"));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        String newStr = null;

        if (string == null)
            throw new TooShortStringException();

        int countOfTab = 0;

        for (int i = 0; i < string.length(); i++) {
            char[] charString = string.toCharArray();
            if (charString[i] == '\t') {
                countOfTab++;
            }
        }

        if (countOfTab < 2) {
            throw new TooShortStringException();
        }


        newStr = string.substring(string.indexOf("\t"), string.indexOf("\t", string.indexOf("\t") + 1));
        newStr = newStr.trim();

        return newStr;
    }

    public static class TooShortStringException extends Exception {
    }
}
