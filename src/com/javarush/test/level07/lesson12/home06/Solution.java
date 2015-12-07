package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей.
Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        Human grandFather1 = new Human("Soul", true, 99, null, null);
        Human grandFather2 = new Human("Henry", true, 69, null, null);
        Human grandMother1 = new Human("Helen", false, 87, null, null);
        Human grandMother2 = new Human("Mary", false, 59, null, null);
        Human father = new Human("Tor", false, 40, grandFather2, grandMother2);
        Human mother = new Human("Susan", false, 42, grandFather1, grandMother1);

        Human Child1 = new Human("Ann", false, 20, father, mother);
        Human Child2 = new Human("Serj", true, 20, father, mother);
        Human Child3 = new Human("Pitt", true, 20, father, mother);

        System.out.println(grandFather1.toString());
        System.out.println(grandFather2.toString());
        System.out.println(grandMother1.toString());
        System.out.println(grandMother2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(Child1.toString());
        System.out.println(Child2.toString());
        System.out.println(Child3.toString());

    }

    public static class Human
    {
        //Написать тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private Human mother;
        private Human father;


        Human (String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
