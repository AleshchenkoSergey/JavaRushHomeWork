package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Admin on 21.01.2015.
 */
public class UkrainianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 5;
    }

    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
