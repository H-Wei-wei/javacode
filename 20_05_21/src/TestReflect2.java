// Duplicate class found in the file

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Animal {
    public String name = "初一";

    public Animal() {

    }

    public Animal(String name) {
        this.name = name;
    }

    public void eat(String food) {
        System.out.println(name + "正在吃" + food);
    }
    public void eat(String food1, String food2) {
        System.out.println(name + "正在吃" + food1 + "和" + food2);
    }
}

public class TestReflect2 {

    public static void TestaInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 借助反射来实例化对象
        Class animalClass = Class.forName("Animal");
        Animal animal = (Animal) animalClass.newInstance();
    }

    public static void TestField() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        // 1.先获取类对象
        Class animalClass = Class.forName("Animal");
        // 2、借助类对象，来获取到指定的 field 对象
        // 进一步获取到的 field 对象相当于从一个大图纸中获取了一个小图纸
        Field field = animalClass.getDeclaredField("name");
        field.setAccessible(true); // 专门处理 private 成员的方法
        // 3、根据图纸来获取 / 修改 对象的相关字段
        Animal animal = new Animal();
        // 通过 get 来获取成员属性
        // 通过 set 来修改属性
        field.set(animal,"初五");
        // 找到 Animal 对象中的名为 name 的成员，并且获取到值
        String name = (String) field.get(animal);
        System.out.println(name);
    }

    public static void TestMethod() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 1.先创建类对象
        Class animalClass = Class.forName("Animal");
        // 2、根据类对象来获取 Method 对象
        // 这个表示一个参数的 eat 方法
        Method method = animalClass.getMethod("eat",String.class);
        method.setAccessible(true);
        // 表示两个参数的 eat 方法
        // Method method1 = animalClass.getMethod("eat",String.class,String.class);
        // 3、借助 method 来调用指定的方法（对于非静态方法，需要通过实例来调用）
        Animal animal = new Animal();
        method.invoke(animal, "肉");
    }
    public static void TestConstuctor() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 1、先创建类对象
        Class animalClass = Class.forName("Animal");
        // 2、通过类对象来获取 Construction 对象
        Constructor constructor = animalClass.getConstructor(String.class);
        constructor.setAccessible(true);
        // 3、根据 ConStructor 实例化对象
        Animal animal = (Animal) constructor.newInstance("十五");
        animal.eat("肉");
    }
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        TestField();
        TestMethod();
        TestConstuctor();
    }
}
