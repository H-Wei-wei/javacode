
public class TestDemo {
    String str = new String("hello");
    char[] ch = {'a', 'b', 'c'};
    public static void main(String[] args) {
        TestDemo ex = new TestDemo();
        exchange(ex.str,ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);

    }

    private static void exchange(String str, char[] ch) {
        str = "what";
        ch[1] = 'm';
    }

    public static void main1(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operator(a, b);
        System.out.println(a + "," + b);
    }

    private static void operator(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
    }
}
