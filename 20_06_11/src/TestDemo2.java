import java.util.Arrays;

public class TestDemo2 {

    String str ="good";
    char[] ch = { 'a', 'b', 'c' };

    public static void main(String args[]) {
        TestDemo2 ex = new TestDemo2();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str + " and " + ex.ch);
        System.out.println(ex.ch);
    }

    public void change(String str, char ch[]) {
        System.out.println("string以前的hashCode:"+str.hashCode());
        str = "test ok";
        System.out.println("stringHash改变值之后的Code:"+str.hashCode());
        ch[0] = 'g';
    }
}
