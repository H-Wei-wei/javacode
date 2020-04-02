package com.bit.src;

public class Animal {
    int count;
    protected String sex;

    public String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(this.name+" 正在吃");
    }

}
