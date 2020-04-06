package com.bit.demo4;

/**
 *接口
 * 比抽象类更抽象
 * 1、用interface关键字来修饰
 * 2、里边的数据必须是常量  默认是public static final
 * 3、里边的方法默认是public abstract
 * 4、里边的方法都不能有具体实现
 * 5、JDK1.8新特性：接口中可以有实现的方法，但是得用default修饰
 * 6、一个类和接口的关系   实现--》implements 可以实现多个接口
 * 7、解决了java中单继承的问题
 */
interface  IShape {
    int a = 12;//默认是public static final
    void func();//默认是 public abstract
    default void hW() {
        System.out.println("哈哈");
    }
}
/*interface A{

}
class Cycle implements IShape,A {
    @Override
    public void func() {
        System.out.println("圆");
    }
}*/

class Cycle implements IShape{
    @Override
    public void func() {
        System.out.println("圆");
    }

    @Override
    public void hW() {
        System.out.println("呵呵");
    }
}

class Rect implements IShape {
    @Override
    public void func() {
        System.out.println("矩形");
    }
}

public class TestDemo {
    public static void main(String[] args) {
        IShape shape1 = new Cycle();
        shape1.hW();
        IShape shape2 = new Rect();
        shape2.func();
    }
}
