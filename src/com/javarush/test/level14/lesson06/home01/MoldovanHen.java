package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Admin on 21.01.2015.
 */

public class MoldovanHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 3;
    }

    String getDescription() {

        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
