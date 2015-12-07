package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        String result = outputStream.toString();

        System.setOut(consoleStream);

        char[] charResult = result.toCharArray();

        ArrayList<Character> listCharResult = new ArrayList<>();
        ArrayList<Character> firstNumberChar = new ArrayList<>();
        ArrayList<Character> secondNumberChar = new ArrayList<>();

        for (int i = 0; i < charResult.length; i++) {
            listCharResult.add(charResult[i]);
        }


        for (int i = 0; i < listCharResult.size();) {
            if (Character.isDigit(listCharResult.get(i))) {
                firstNumberChar.add(listCharResult.get(i));
                listCharResult.remove(i);
            }
            if (listCharResult.get(i) == ' ') {
                break;
            }
        }

        char operator = ' ';

        for (int i = 0; i < listCharResult.size(); i++) {
            if (Character.isDigit(listCharResult.get(i))) {
                secondNumberChar.add(listCharResult.get(i));
            }
            if (listCharResult.get(i) == '+' || listCharResult.get(i) == '-' || listCharResult.get(i) == '*') {
                operator = listCharResult.get(i);
            }
        }



        String firstNumberString = "";
        String secondNumberString = "";

        for (int i = 0; i < firstNumberChar.size(); i++) {
            firstNumberString = firstNumberString + Character.toString(firstNumberChar.get(i));
        }
        for (int i = 0; i < secondNumberChar.size(); i++) {
            secondNumberString = secondNumberString + Character.toString(secondNumberChar.get(i));
        }

        if (operator == '+') {
            int ans = Integer.parseInt(firstNumberString) + Integer.parseInt(secondNumberString);
            result = result + ans;
        }
        if (operator == '-') {
            int ans = Integer.parseInt(firstNumberString) - Integer.parseInt(secondNumberString);
            result = result + ans;
        }
        if (operator == '*') {
            int ans = Integer.parseInt(firstNumberString) * Integer.parseInt(secondNumberString);
            result = result + ans;
        }


        result = result.replaceAll("\\p{Cntrl}", "");


        System.out.println(result);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 * 4546 = ");
        }
    }
}

