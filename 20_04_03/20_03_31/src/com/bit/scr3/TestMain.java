package com.bit.scr3;

import javafx.scene.AmbientLight;

class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println("Animal: "+this.name+"正在吃");
    }
}

class Bird extends Animal {

    public Bird(String name) {
        super(name);
    }

    public void fly() {
        System.out.println(this.name+"正在飞");
    }

    //重写
    public void eat() {
        System.out.println("Bird: "+this.name+"正在吃");
    }

}
/*
class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

}
*/

public class TestMain {

    public static void main(String[] args) {
        Animal animal = new Bird("憨憨");
        animal.eat();
    }

/*    public static void func(Animal animal) {
        animal.eat();
    }
    public static Animal func2(){
        return new Bird("初三");
    }
    public static void main(String[] args) {
        Bird bird = new Bird("初二");
        func(bird);
    }

    public static void main2(String[] args) {
        //父类引用子类的对象  ---》  向上转型
        Animal animal = new Bird("初一");
        animal.eat();
        //animal.fly();
    }

    public static void main1(String[] args) {
        Animal animal = new Animal("哈哈");

        Bird bird = new  Bird("初一");

        Cat cat = new Cat("咪咪");
    }*/

}
