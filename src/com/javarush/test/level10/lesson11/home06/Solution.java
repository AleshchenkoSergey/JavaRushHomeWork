package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        private String name;
        private int age;
        private boolean sex;
        private int weight;
        private String job;
        private String shouldersColor;

        Human(String n) {
            name = n;
        }

        Human(String n, int a) {
            name = n;
            age = a;
        }

        Human(String n, int a, boolean s) {
            name = n;
            age = a;
            sex = s;
        }

        Human(String n, int a, boolean s, int w) {
            name = n;
            age = a;
            sex = s;
            weight = w;
        }
        Human(String n, int a, int w, boolean s) {
            name = n;
            age = a;
            sex = s;
            weight = w;
        }
        Human(int w, String n, int a, boolean s) {
            name = n;
            age = a;
            sex = s;
            weight = w;
        }

        Human(int a, String n, boolean s, String j) {
            name = n;
            age = a;
            sex = s;
            job = j;
        }
        Human(int a, String n, boolean s) {
            name = n;
            age = a;
            sex = s;
        }

        Human(String n, boolean s, int a) {
            name = n;
            age = a;
            sex = s;
        }

        Human(String n, boolean s) {
            name = n;
            sex = s;
        }
    }
}
