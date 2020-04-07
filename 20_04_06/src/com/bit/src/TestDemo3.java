package com.bit.src;

/**
 * cloneable接口
 *
 * 自定义类型中
 * 使用clone()方法前
 * 1、需实现cloneable接口
 * 2、需要重写Object中的clone方法
 *
 * cloneable接口为啥是一个空接口？
 * 空接口 ：标志接口 ----》一个类实现cloneable接口，就代表这个类可以被克隆
 *
 */

class Money {
    public int money = 18;
}
class Person implements Cloneable {

    public int age;

    public Money m;

    public Person(int age) {
        this.age = age;
        this.m = new Money();
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

public class TestDemo3 {

    //clone浅拷贝
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person(12);
        Person person1 = (Person) person.clone();

        System.out.println(person.m.money);//18
        System.out.println(person1.m.money);//18
        System.out.println("====================");
        person1.m.money = 100;
        System.out.println(person.m.money);//100
        System.out.println(person1.m.money);//100
    }

    public static void main1(String[] args) throws CloneNotSupportedException {
        Person person = new Person(12);
        Person person1 = (Person) person.clone();

        System.out.println(person.age); //12
        System.out.println(person1.age);//12
        System.out.println("====================");
        person1.age = 999;
        System.out.println(person.age);//12
        System.out.println(person1.age);//999

       /* try {
            Person person1 = (Person) person.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }*/
    }
}
