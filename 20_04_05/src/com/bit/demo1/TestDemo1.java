package com.bit.demo1;


class Base {
    public int a;

    static {
        System.out.println("Base的静态代码块");
    }
    {
        System.out.println("Base的实例代码块");
    }

    public Base(int a) {
        this.a = a;
        System.out.println("Base的constructor");
    }

    public void func() {
        System.out.println("Base: func");
    }
}

class Derive extends Base {

    public int b;

    static {
        System.out.println("Derive的静态代码块");
    }
    {
        System.out.println("Derive的实例代码块");

    }

    public Derive(int a, int b) {
        super(a);
        System.out.println("Derive的constructor");
    }

    public void func() {
        //System.out.println(this.a);
        System.out.println("Derive: func");
    }

}
public class TestDemo1 {
    public static void main(String[] args) {
        //Base base = new Derive(1,2);//向上转型
        //base.func();//通过父类的引用去调用重写的方法 ————》动态绑定/运行时绑定  ——》 多态

        new Derive(1,2);

        System.out.println("====================");
        new Derive(1,2);

    }

}
