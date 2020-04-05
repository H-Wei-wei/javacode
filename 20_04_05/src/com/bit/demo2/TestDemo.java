package com.bit.demo2;

import java.awt.*;

class Shape {

    public void draw() {

    }
}

class Rect extends Shape {

    public void draw() {
        System.out.println("画一个矩形");
    }
}

class Cycle extends Shape {

    @Override
    public void draw() {
        System.out.println("画一个圆");
    }
}

public class TestDemo {

    public static void main(String[] args) {

    }

    public static void main4(String[] args) {
        Shape[] shapes ={new Cycle(),new Rect()};
        for (Shape shape:shapes) {
            shape.draw();
        }
    }

    public static Shape drawMap1() {
        return new Cycle();
    }
        //返回值
    public static void main3(String[] args) {
        Shape shape = drawMap1();
        shape.draw();
    }

    //传参
    public static void drawMap(Shape shape) {
        shape.draw();
    }
    public static void main2(String[] args) {
        Shape shape1 = new Cycle();
        drawMap(shape1);

        Shape shape2 = new Rect();
        drawMap(shape2);
    }

    //直接赋值
    public static void main1(String[] args) {

        Shape shape1 = new Cycle();
        shape1.draw();

        Shape shape2 = new Rect();
        shape2.draw();

    }
}
