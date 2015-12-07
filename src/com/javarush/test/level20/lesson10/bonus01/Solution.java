package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {

    public static void main(String[] args) {
        Long t0 = System.currentTimeMillis();
        int n = 100000000;
        int[] numbers = getNumbers(n);
        Long t1 = System.currentTimeMillis();
        System.out.println("time: " + (t1 - t0) / 1000d + " sec");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ", ");
        }
        System.out.println();
    }

    public static int[] getNumbers(int N) {
        int[] result = null;
        List<Integer> resultList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            int numberLength = (i + "").length();
            int resultSum = 0;
            int resultMul = 1;

            for (int j = 0; j < numberLength; j++) {
                char currentChar = (i + "").charAt(j);
                int currentNumber = Integer.parseInt(Character.toString(currentChar));

                for (int k = 0; k < numberLength; k++) {
                    resultMul = resultMul * currentNumber;
                }


                resultSum += resultMul;
                resultMul = 1;
            }

            if (resultSum == i) {
                resultList.add(i);
            }

            resultSum = 0;
        }

        result = new int[resultList.size()];

        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
