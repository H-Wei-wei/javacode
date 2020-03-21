

class Book {

    private String name = "weiwei";
    public String author;
    public int price;

    public static int count;

    //实例代码块/构造代码块
    {
        //可以对属性进行初始化
        //this ----> 当前对象的引用
        /*this.name = "西游记";
        this.author = "吴承恩";
        this.price = 99;
        count = 100;*/
        System.out.println("实例代码块/构造代码块");
    }

 //实例代码块可以初始化非静态的成员变量，静态的也可以
 //静态代码块只能初始静态成员变量

    //静态代码块
    // -----静态的会先被执行且只会被执行一次
    static {
        //this.name = "西游记";  error
        //静态代码块中，是不可以初始普通的成员变量
        //原因：static是不依赖对象的
        count = 99;
        System.out.println("静态代码块");
    }

    //不带有参数的构造方法
    public Book() {
        System.out.println("Book()");
    }

    //带有参数的构造方法
    public Book(String name, String author, int price) {
        this.name = name;
        this.author = author;
        this.price = price;
        System.out.println("Book(String,String,int)");
    }

    //封装
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public void show() {
        System.out.println("书名："+name+
                "  作者："+author+
                "  价格："+price);
    }

    //重写Object：toString方法
    @Override  //注解：Override重写
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
    //一但被重写，那么会优先调用当前类重写的这个方法！！！

}public class TestDemo {

    public static void main(String[] args) {
        Book book = new Book("西游记","吴承恩 ",999);
        System.out.println(book);
        //book.show();

        new Book().show();  //匿名对象  只能用一次
        //new Book().toString();   输出什么都没有

    }

    public static void main2(String[] args) {
        Book book = new Book(); //实例化一个对象
        System.out.println(book.getName());
        System.out.println(book.getAuthor());
        System.out.println(book.getPrice());
        System.out.println("====================");
        Book book2 = new Book();

        System.out.println("====================");
    }

    public static void main1(String[]args){
        Book book1 = new Book();
        System.out.println(book1.getName());
        Book book2 = new Book();
        Book book3 = new Book();
    }
}



/*public class TestDemo {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println("s = "+s);
    }
}*/

/*
class Test {
    public static void hello() {
        System.out.println("hello");
    }
}
public class TestDemo {
    public static void main(String[] args) {
        Test test = null;
        Test.hello();
    }
}*/

/*class Test {

    private String name = "Person";

    int age=0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class  TestDemo{

    public String grade;

    public static void main(String[] args){

        Test p = new Test();

        System.out.println(p.getName());

    }

}*/

