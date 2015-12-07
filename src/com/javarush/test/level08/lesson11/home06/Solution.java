package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        Human child1 = new Human();
        child1.age = 12;
        child1.name = "Vova";
        child1.sex = true;

        Human child2 = new Human();
        child2.age = 20;
        child2.name = "Anna";
        child2.sex = false;

        Human child3 = new Human();
        child3.age = 15;
        child3.name = "Stasik";
        child3.sex = true;

        Human father = new Human();
        father.age = 45;
        father.name = "Philipp";
        father.sex = true;
        father.children.add(child1);
        father.children.add(child2);
        father.children.add(child3);

        Human mother = new Human();
        mother.age = 43;
        mother.name = "Elena";
        mother.sex = false;
        mother.children.add(child1);
        mother.children.add(child2);
        mother.children.add(child3);

        Human grandfather1 = new Human();
        grandfather1.age = 88;
        grandfather1.name = "Taras";
        grandfather1.sex = true;
        grandfather1.children.add(father);

        Human grandfather2 = new Human();
        grandfather2.age = 72;
        grandfather2.name = "Mazay";
        grandfather2.sex = true;
        grandfather2.children.add(mother);

        Human grandmother1 = new Human();
        grandmother1.age = 82;
        grandmother1.name = "Zina";
        grandmother1.sex = false;
        grandmother1.children.add(father);

        Human grandmother2 = new Human();
        grandmother2.age = 69;
        grandmother2.name = "Luba";
        grandmother2.sex = false;
        grandmother2.children.add(mother);

        System.out.println(grandfather1.toString());
        System.out.println(grandfather2.toString());
        System.out.println(grandmother1.toString());
        System.out.println(grandmother2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());

    }

    public static class Human
    {
        //Написать тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
