package com.bit.src;


class Money{

}
class person{
    public Money money;
}

public class TestDemo {

    public static void main(String[] args) {
        Animal animal = new Animal("嗨喽");
        System.out.println(animal.sex);
    }

    public static void main2(String[] args) {
        Bird bird = new Bird("初一",12);
        bird.eat();
        bird.fly();
        System.out.println(bird.name+"的年龄是"+bird.age);

    }

    public static void main1(String[] args) {
        Dog dog = new Dog("晶晶");
        dog.eat();
    }

}
