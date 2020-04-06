package com.bit.demo5;

/**
 * 接口可以将功能独立
 *
 * 接口不能被接口实现的
 *
 * 接口与接口可以通过extends来连接
 *一个接口可以继承多个接口，实现接口的扩展
 */

interface A {
    void func1();
}
interface B extends A{
    void func2();
}
interface C extends B{
    void func3();
}

//抽象类是用来被继承的
abstract class Shape implements A {
    public String name;
    public abstract void func();

}
class Cycle extends Shape {
    @Override
    public void func() {
        System.out.println("呵呵");
    }

    @Override
    public void func1() {
        System.out.println("哈哈");
    }
}


class AA implements C {
    @Override
    public void func1() {
        System.out.println("func1");
    }

    @Override
    public void func2() {
        System.out.println("func2");
    }

    
    @Override
    public void func3() {
        System.out.println("func3");
    }
}

//-----------------------------分隔符---------------------------------

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

interface  IRunning {
    void run();
}
interface IEating {
    void eat();
}
interface IFlying {
    void fly();
}

//一个类可以继承一个类实现多个接口
class Cat extends Animal implements IEating,IRunning {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.getName()+"正在跑");
    }

    @Override
    public void eat() {
        System.out.println(this.getName()+"正在吃");
    }
}

class Bird extends Animal implements IFlying,IEating{
    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(this.getName()+"正在吃");
    }

    @Override
    public void fly() {
        System.out.println(this.getName()+"正在飞");
    }
}

public class TestDemo {

    public static void main(String[] args) {
        Cycle cycle = new Cycle();
        cycle.func();
        cycle.func1();
    }

    public static void run(IRunning iRunning) {
        iRunning.run();
    }
    public static void eat(IEating iEating) {
        iEating.eat();
    }
    public static void fly(IFlying iFlying) {
        iFlying.fly();
    }

    public static void main1(String[] args) {
        Cat cat = new Cat("初一");
        eat(cat);
        run(cat);

        Bird bird = new Bird("鸟");
        eat(bird);
        fly(bird);
    }

}
