package com.javarush.test.level22.lesson05.task01;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("    1 1 1 1 1"));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) throw new TooShortStringException();

        Pattern pattern = Pattern.compile("(?:\\s)(\\S*\\s\\S*\\s\\S*\\s\\S*)");

        Matcher matcher = pattern.matcher(string);

        LinkedList<String> list = new LinkedList<>();

        while (matcher.find()) {
            list.add(matcher.group(1));
        }

        if (list.isEmpty()) throw new TooShortStringException();

        return list.get(0).toString();

    }

    public static class TooShortStringException extends Exception {
    }
}
