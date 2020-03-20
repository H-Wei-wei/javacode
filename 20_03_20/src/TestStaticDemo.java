

class Test{
    public int a; //普通成员变量
    public static int count;//静态成员变量

    //静态成员变量在类中只有一份
}
public class TestStaticDemo {

    public static void main(String[] args) {
    Test t1 = new Test();  //实例化对象
    t1.a++;    //  1
    Test.count++;  //  1
    System.out.println(t1.a);  //  1
    System.out.println(Test.count);   //  1
    System.out.println("============");
    Test t2 = new Test();
    t2.a++;    //  1
    Test.count++;  //  2
    System.out.println(t2.a);  //   1
    System.out.println(Test.count);  //   2
   }
}