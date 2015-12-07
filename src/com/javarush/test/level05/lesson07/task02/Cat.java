package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес.
Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    private String catName;
    private int catWeight;
    private int catAge;
    private String catColor;
    private String catAddr;

    private int noWeight;
    private String noName;
    private String noAddr;
    private int noAge;

    public void initialize(String name) {
        this.catName = name;
    }

    public void initialize(String name, int weight, int age) {
        this.catName = name;
        this.catWeight = weight;
        this.catAge = age;
    }

    public void initialize(String name, int age) {
        this.catName = name;
        this.catAge = age;
        this.catWeight = this.noWeight;
    }

    public void initialize(int weight, String color) {
        this.catWeight = weight;
        this.catColor = color;
        this.noName = null;
        this.noAddr = null;
        this.noAge = 5;
    }

    public void initialize(int weight, String color, String addr) {
        this.catWeight = weight;
        this.catColor = color;
        this.catAddr = addr;
        this.noName = null;
        this.noAge = 5;
    }
}
