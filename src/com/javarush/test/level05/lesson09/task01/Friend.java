package com.javarush.test.level05.lesson09.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя конструкторами:
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
    private String Fname = null;
    private int Fage;
    private String Fgender = null;

    public Friend(String name) {
        this.Fname = name;
    }

    public Friend(String name,int age) {
        this.Fname = name;
        this.Fage = age;
    }

    public Friend(String name,int age, String gender) {
        this.Fname = name;
        this.Fage = age;
        this.Fgender = gender;
    }

}