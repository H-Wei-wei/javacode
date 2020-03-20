

//所有的静态的方法或者属性，都是需要通过类名来调用的，不依赖于对象

//class用来声明————声明一个类Person
 class Person{
    public String name ;   //属性————>字段、成员变量
    public int age ;
    public boolean flg;
    public char ch;

    public static int count;  //静态成员属性  不属于对象  属于类本身
    public final int SIZE = 10;  //final修饰的常量--不能被修改的
    //一个属性存放在内存的哪个区域，和是否被final所修饰无关

    public static final int SIZE2 = 10;

    //行为————>成员方法
    public void eat() {
        System.out.println("吃饭!");
    }
    public void sleep() {
        System.out.println("睡觉!");
    }
    public void show() {
        System.out.println("姓名："+name+"  年龄："+ age);
    }
    public static void func(){
        //静态成员方法内，是无法访问非静态数据成员的
        //               可以访问静态数据成员的
        count++;
        System.out.println("ststic::func "+count);
    }
}

public class TestDemo {

    public static void main(String[] args) {
        Person.func();
    }

    public static void main2(String[] args) {
        Person person1 = new Person();
        person1.name = "张三";
        person1.age = 12;
        person1.show();
        //静态成员变量通过类名去访问
        System.out.println("Person:"+Person.count);
        Person.func();
        System.out.println(person1.SIZE);
        System.out.println(Person.SIZE2);
    }

    //public--->访问修饰限定符
    public static void main1(String[] args) {
        //实例化一个对象 ---new关键字
        Person person1 = new Person();
        //System.out.println(person1);//地址的哈希值

        //Person person2 = new Person();
        //Person person3 = new Per son();

        //给成员属性初始化
        person1.name = "小高老师";
        person1.age = 12;
        person1.flg = false;
        person1.ch = '曹';

        //访问Person的属性（成员变量）
        System.out.println(person1.name);
        //length()取name的长度
        System.out.println(person1.name.length());
        System.out.println(person1.age);
        System.out.println(person1.flg);
        System.out.println(person1.ch);
        //**成员变量如果没有初始值，那么它的打印纸是一个默认值，
        //                      即对应类型的0值
        // 引用类型:  String ----- null
        //  双精度:  doublde -----  0.0
        //   单精度：  float -----  0.0f
        // 布尔类型: boolean ----- false
        //    整形:      int -----   0
        //    字符：     char -----  ‘\u0000'
        person1.sleep();
        person1.eat();
    }
}
