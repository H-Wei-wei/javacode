
/**
 * 反射
 * 类对象
 */

class Cat {

    public String name;

    public void eat(String food) {
        System.out.println(name + "正在吃" + food);
    }

    public Cat(String name) {
        this.name = name;
    }

}
public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException {

        // 获取类对象，获取到 Cat 类的说明书
        // 第一种获取方式是最灵活的，写代码的时候根本不需要知道类名
        // 第二、三种方法都是需要在写代码时就要知道类名

        // 获取类对象
        // 1.通过 全限定类名 来获取
        Class catClass = Class.forName("Cat");
        // 2、通过 类的实例 来获取
        Cat cat= new Cat("初一");
        Class catClass2 = cat.getClass();
        // 3、通过 类 来直接获取
        Class catClass3 = Cat.class;

        System.out.println(catClass == catClass2);
        System.out.println(catClass2 == catClass3);
    }
}
