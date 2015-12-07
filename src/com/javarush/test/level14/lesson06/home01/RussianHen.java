package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Admin on 21.01.2015.
 */
public class RussianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 10;
    }

    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
