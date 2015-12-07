package com.javarush.test.level05.lesson07.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя инициализаторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius, width, color
*/

public class Circle
{
    private double cX;
    private double cY;
    private double r;
    private double cW;
    private String col;

    public void initialize(double centerX, double centerY, double radius) {
        this.cX = centerX;
        this.cY = centerY;
        this.r = radius;
    }

    public void initialize(double centerX, double centerY, double radius, double width) {
        this.cX = centerX;
        this.cY = centerY;
        this.r = radius;
        this.cW = width;
    }

    public void initialize(double centerX, double centerY, double radius, double width, String color) {
        this.cX = centerX;
        this.cY = centerY;
        this.r = radius;
        this.cW = width;
        this.col = color;
    }

}
