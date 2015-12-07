package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);

        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();
        int n4 = scanner.nextInt();

        if (n1 >= n2)
            if (n1 >= n3)
                if (n1 >= n4) System.out.println(n1);
                else System.out.println(n4);
            else
                if (n4 >= n3) System.out.println(n4);
                else System.out.println(n3);
        else
            if (n2 >= n3)
                if (n2 >= n4) System.out.println(n2);
                else System.out.println(n4);
            else
                if (n4 >= n3) System.out.println(n4);
                else System.out.println(n3);
    }

}

