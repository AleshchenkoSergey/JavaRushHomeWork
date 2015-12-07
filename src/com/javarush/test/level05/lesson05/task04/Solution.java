package com.javarush.test.level05.lesson05.task04;

/* Создать три объекта типа Cat
В методе main создать три объекта типа Cat и заполнить их данными.
Использовать класс Cat из первой задачи. Класс Cat создавать не надо.
*/

public class Solution {
    public static void main(String[] args) {
//        com.javarush.test.level05.lesson05.task01.Cat cat1 = new com.javarush.test.level05.lesson05.task01.Cat();
//        com.javarush.test.level05.lesson05.task01.Cat cat2 = new com.javarush.test.level05.lesson05.task01.Cat();
//        com.javarush.test.level05.lesson05.task01.Cat cat3 = new com.javarush.test.level05.lesson05.task01.Cat();
        Cat cat1 = new Cat("Vaska", 12, 12, 12);
        Cat cat2 = new Cat("Vaska", 12, 12, 12);
        Cat cat3 = new Cat("Vaska", 12, 12, 12);

//        cat1.name  = "Vaska";
//        cat2.name  = "Vaska";
//        cat3.name  = "Vaska";
//
//        cat1.age = 12;
//        cat2.age = 12;
//        cat3.age = 12;
//
//        cat1.weight = 2;
//        cat2.weight = 2;
//        cat3.weight = 2;
//
//        cat1.strength = 15;
//        cat2.strength = 15;
//        cat3.strength = 15;
    }

    public static class Cat {

        public static int count = 0;
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength) {
            count++;

            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }
    }
}
