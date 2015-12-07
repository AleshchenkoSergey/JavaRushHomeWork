package com.javarush.test.level05.lesson09.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота).
Создать для него как можно больше конструкторов:
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    private double top = 0;
    private double left = 0;
    private double width = 0;
    private double height = 0;

    public Rectangle (double t, double l, double w, double h) {
        this.top = t;
        this.left = l;
        this.width = w;
        this.height = h;
    }
    public Rectangle (double t, double l) {
        this.top = t;
        this.left = l;
    }
    public Rectangle (double t, double l, double w) {
        this.top = t;
        this.left = l;
        this.width = w;
        this.height = this.width;
    }
    public Rectangle (Rectangle rec) {
        Rectangle rectangle = rec;
    }

}
