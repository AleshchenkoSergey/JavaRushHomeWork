package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота).
Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    double left;
    double top;
    double width;
    double height;

    public void initialize(double l, double t, double w, double h) {
        this.left = l;
        this.top = t;
        this.width = w;
        this.height = h;

    }

    public void initialize(double l, double t) {
        this.left = l;
        this.top = t;
        this.width = 0;
        this.height = 0;
    }

    public void initialize(double l, double t, double w) {
        this.left = l;
        this.top = t;
        this.width = w;
        this.height = this.width;
    }

    public void initialize(Rectangle r) {
        Rectangle re1 = r;
    }


}
