package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    private String DogName = null;
    private int DogGrowth;
    private String DogColor = null;

    public Dog (String name) {
        this.DogName = name;
    }
    public Dog (String name, int growth) {
        this.DogName = name;
        this.DogGrowth = growth;
    }
    public Dog (String name, int growth, String color) {
        this.DogName = name;
        this.DogGrowth = growth;
        this.DogColor = color;
    }

}
