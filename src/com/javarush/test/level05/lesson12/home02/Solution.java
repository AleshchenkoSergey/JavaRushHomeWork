package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        Man man = new Man("Толик", 25, "Мухосранск сити, ул. Новодрищенская, д. 5");
        Woman woman = new Woman("Даздраперма", 22, "Мухосранск сити, ул. Новодрищенская, д. 6");

        System.out.println(man.name + " " + man.age + " " + man.address);
        System.out.println(woman.name + " " + woman.age + " " + woman.address);
    }

    public static class Man
    {
        private String name = null;
        private int age;
        private String address = null;

        public Man (String n, int a, String addr)
        {
            this.name = n;
            this.age = a;
            this.address = addr;
        }

        public Man (String n, int a)
        {
            this.name = n;
            this.age = a;
        }
    }

    public static class Woman
    {
        private String name = null;
        private int age;
        private String address = null;

        public Woman (String n, int a, String addr)
        {
            this.name = n;
            this.age = a;
            this.address = addr;
        }

        public Woman (String n, int a)
        {
            this.name = n;
            this.age = a;
        }
    }
}
