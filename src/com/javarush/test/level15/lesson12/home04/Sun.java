package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Admin on 31.01.2015.
 */
public class Sun implements Planet {
    private static Sun ourInstance = new Sun();

    public static Sun getInstance() {
        return ourInstance;
    }

    private Sun() {
    }
}
