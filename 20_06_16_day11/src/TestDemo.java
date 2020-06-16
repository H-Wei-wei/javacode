
class A {
    public A() {

    }
}
class B extends A {
    public B() {

    }
}
class C extends B {
    public C() {
    }
}
public class TestDemo {

    public static void main(String[] args) {
        /*String s1 = "abc" + "def";
        String s2 = new String(s1);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));*/
        A a0 = new A();
        A a1 = new B();
        A a2 = new C();

    }
}
