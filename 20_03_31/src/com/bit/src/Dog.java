package com.bit.src;

public class Dog  extends Animal{

    public Dog(String name) {
        //构造方法之前先构造对象的方法
        //构造父类，代表调用父类的带有一个参数的构造方法，只能构造一次
        super(name);
    }

    public void testProtected(){
        System.out.println(this.sex);
    }


    /*public String name;
    public void eat() {
        System.out.println(this.name+" 正在吃");
    }*/

}
