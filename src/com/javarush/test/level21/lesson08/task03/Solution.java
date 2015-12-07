package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Запретите клонировать класс B
Разрешите клонировать класс C
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        protected A clone() throws CloneNotSupportedException {
            return new A(getI(), getJ());
        }

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        protected B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        protected C clone() {
            return new C(getI(), getJ(), getName());
        }

    }
}
