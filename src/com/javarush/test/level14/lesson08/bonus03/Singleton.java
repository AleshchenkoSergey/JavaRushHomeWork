package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Admin on 26.01.2015.
 */
public class Singleton {
    private static Singleton singleton = new Singleton();

    static Singleton getInstance() {
        return singleton;
    }

    private Singleton() {

    }
}
