package com.bit.demo3;


abstract class Shape {

    public abstract  void draw();
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

}
