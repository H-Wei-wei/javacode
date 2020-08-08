package com.bit.src2;

import com.bit.src.Animal;

public class Test extends Animal {

    public Test(String name) {
        super(name);
    }

    public void func() {
        System.out.println(super.sex);
        //System.out.println(super.count);
    }

    public static void main(String[] args) {
        Animal animal = new Animal("嗨喽");
        //super是对象的引用 不依赖于对象
        //System.out.println(animal.sex);

    }
}
