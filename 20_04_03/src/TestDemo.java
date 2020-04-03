/*

class X{
    Y y=new Y();
    public X(){
        System.out.print("X");
    }
}
class Y{
    public Y(){
        System.out.print("Y");
    }
}
public class TestDemo extends X{
    Y y=new Y();
    public TestDemo(){
        System.out.print("Z");
    }
    public static void main(String[] args) {
        new TestDemo();
    }
}
*/
/*

class Base{

    public Base(String s){

        System.out.print("B");

    }

}

public class Derived extends Base{

    public Derived (String s) {

        super();

        System.out.print("D");

    }

    public static void main(String[] args){

        new Derived("C");

    }
}
*/




class Base {

    Base() {

        System.out.print("Base");

    }

}

public class TestDemo extends Base {

    public static void main( String[] args ) {

        new TestDemo();

        //调用父类无参的构造方法

        new Base();

    }

}
