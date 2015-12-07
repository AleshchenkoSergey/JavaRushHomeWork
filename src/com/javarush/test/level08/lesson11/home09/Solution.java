package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(isDateOdd("JANUARY 1 2000"));
        System.out.println(isDateOdd("JANUARY 2 2020"));
        System.out.println(isDateOdd("JANUARY 3 2020"));


    }

    public static boolean isDateOdd(String date) {

        Date currentDate = new Date(date);

        Date startYear = new Date(0);
        startYear.setHours(0);
        startYear.setMinutes(0);
        startYear.setSeconds(0);
        startYear.setDate(1);
        startYear.setMonth(0);
        startYear.setYear(currentDate.getYear());



        long dist = currentDate.getTime() - startYear.getTime();
        long msDelay = 24*60*60*1000;

        int dayCount = (int)(dist/msDelay + 1);

        return (dayCount % 2 != 0);
    }
}
