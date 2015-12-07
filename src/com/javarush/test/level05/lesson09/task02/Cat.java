package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес не известен,
то нужно указать какой-нибудь средний вес. Кот не может ничего не весить.
То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    private String CatName = null;
    private String CatColor = null;
    private String CatAddr = null;
    private int CatWeight;
    private int CatAge;
    private int sWeight;
    private int sAge;

    public Cat(String name) {
        this.CatName = name;
        this.CatAge = sAge;
        this.CatWeight = sWeight;
    }
    public Cat(String name, int weight, int age) {
        this.CatName = name;
        this.CatWeight = weight;
        this.CatAge = age;
    }
    public Cat(String name, int age) {
        this.CatName = name;
        this.CatAge = age;
        this.CatWeight = sWeight;
    }

    public Cat(int weight, String color) {
        this.CatWeight = weight;
        this.CatColor = color;
        this.CatAge = sAge;
    }


    public Cat(int weight, String color, String addr) {
        this.CatWeight = weight;
        this.CatColor = color;
        this.CatAddr = addr;
        this.CatAge = sAge;
    }

}
