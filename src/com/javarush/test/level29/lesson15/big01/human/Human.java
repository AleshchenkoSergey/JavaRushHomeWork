package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {
    private static int nextId = 0;
    private int id;
    private int age;
    private String name;
    private List<Human> children = new ArrayList<>();

    protected Size size = new Size();

    private BloodGroup bloodGroup;

    public static final int FIRST = 1;
    public static final int SECOND = 2;
    public static final int THIRD = 3;
    public static final int FOURTH = 4;

    public Human(String name, int age)
    {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }

    public class Size {
        public int height;
        public int weight;
    }

    public String getPosition() {
        return "Человек";
    }

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human human) {
        children.add(human);
    }

    public void removeChild(Human human) {
        children.remove(human);
    }

    public void setBloodGroup(BloodGroup bg) {
        switch (bg.getCode()) {
            case 1: bloodGroup = BloodGroup.first(); break;
            case 2: bloodGroup = BloodGroup.second(); break;
            case 3: bloodGroup = BloodGroup.third(); break;
            case 4: bloodGroup = BloodGroup.fourth(); break;

        }
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }

    public void live() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Рост: " + size.height +
                            " Вес: " + size.weight);
    }
}
