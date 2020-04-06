package com.bit.demo3;

/**
 * 抽象类：包含抽象方法的类
 * 1、用abstract关建字来修饰
 * 2、抽像类可以包含其他类的属性和方法
 * 3、抽象类与其他类不同的是  包含抽象方法
 * 4、抽象类与其他类不同的是  不可以被实例化
 * 5、抽象类的主要作用是被用来继承的
 *        所以不能被final所修饰
 * 6、抽象方法不能是私有的也不能是static修饰的
 * 7、一个类如果继承了抽象类，就必须重写抽象类的方法
 * 8、如果一个类继承了抽象类，不想重写抽象方法，也可以设置成抽象类
 */

abstract class Shape {
    public int a;

    public void func() {
        System.out.println("抽象类的func");
    }

    //抽像方法：没有具体实现的方法
    public abstract  void draw();
}

abstract class B extends Shape {

}
/*
class C extends B{
    //这里必须要重写方法
}
*/

class A extends Shape {
    @Override
    public void draw() {
        System.out.println("A");
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

    public static void drawMap(Shape shape) {
        shape.draw();
    }
    public static void main(String[] args) {
        Shape shape1 = new Cycle();
        drawMap(shape1);

        Shape shape2 = new Rect();
        drawMap(shape2);
    }

    public static void main1(String[] args) {

        //Shape shape = new Shape() ;  //抽象类不可以被实例化



    }
}
