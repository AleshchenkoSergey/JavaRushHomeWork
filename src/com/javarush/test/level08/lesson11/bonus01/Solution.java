package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here - напиши код тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        String [] list = new String[12];

        list[0] = "January";
        list[1] = "February";
        list[2] = "March";
        list[3] = "April";
        list[4] = "May";
        list[5] = "June";
        list[6] = "July";
        list[7] = "August";
        list[8] = "September";
        list[9] = "October";
        list[10] = "November";
        list[11] = "December";

        int number = 0;
        for (int i = 0; i < 12; i++) {
            if (s.equals(list[i])) number = i;

        }

        System.out.println(list[number] + " is " + (number + 1) + " month");

    }

}
