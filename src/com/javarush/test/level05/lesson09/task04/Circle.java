package com.javarush.test.level05.lesson09.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя конструкторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius, width, color
*/

public class Circle
{
    private double centerX;
    private double centerY;
    private double radius;
    private double width;
    private String color = null;

    public Circle (double cX, double cY, double r) {
        this.centerX = cX;
        this.centerY = cY;
        this.radius = r;
    }
    public Circle (double cX, double cY, double r, double w) {
        this.centerX = cX;
        this.centerY = cY;
        this.radius = r;
    }
    public Circle (double cX, double cY, double r, double w, String col) {
        this.centerX = cX;
        this.centerY = cY;
        this.radius = r;
        this.width = w;
        this.color = col;
    }

}
