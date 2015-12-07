package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    private String dogName;
    private int dogGrowth;
    private String dogColor;

    public void initialize (String name) {
        this.dogName = name;
    }

    public void initialize (String name, int growth) {
        this.dogName = name;
        this.dogGrowth = growth;
    }

    public void initialize (String name, int growth, String color) {
        this.dogName = name;
        this.dogGrowth = growth;
        this.dogColor = color;
    }

}
