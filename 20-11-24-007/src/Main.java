class Base {
    Base() {
        System.out.print("base");
    }
}
class A {

}
class B extends A {

}
class C extends B {

}
public class Main extends Base{
    public static boolean isAdmin(String s) {
        return s.toLowerCase().equals("admin") ;
    }
    public static void main(String[] args) {
//        new Main();
//        new Base();
        //System.out.println(isAdmin("Admin"));
//        A a = new A();
//        A a2 = new B();
//        A a3 = new C();
        int[] A = {1,2,3,4,5,6,7,0};
        System.out.println(count(A, 8));
    }

    public static int count(int[] A, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A[i] > A[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
