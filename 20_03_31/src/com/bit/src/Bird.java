package com.bit.src;

public class Bird extends  Animal {

    public  int age;

    public Bird(String name,int age) {
        //子类并没有继承父类的构造方法，只是进行了调用，通过super（）
        super(name);
        this.age = age;
    }

    /*public String name;

    public void eat() {
        System.out.println(this.name+" 正在吃");
    }*/

    public void fly() {
        System.out.println(this.name+" 正在飞");
        System.out.println(this.name);
        //调用父类的属性，
        super.eat();
    }

}
