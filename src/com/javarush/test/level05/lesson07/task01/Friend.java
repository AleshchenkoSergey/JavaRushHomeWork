package com.javarush.test.level05.lesson07.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя инициализаторами (тремя методами initialize):
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
    private String personName = null;
    private int personAge;
    private String personGender = null;

    public void initialize(String name) {
        this.personName = name;
    }
    public void initialize(String name, int age) {
        this.personAge = age;
    }
    public void initialize(String name, int age, String gender) {
        this.personGender = gender ;
    }



}
