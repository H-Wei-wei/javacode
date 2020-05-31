import java.util.Arrays;
import java.util.Scanner;

public class TestDemo {

    // 回文字符串
    public static boolean reverse(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
           if (s.charAt(left) == s.charAt(right)) {
               left++;
               right--;
           }else {
               return false;
           }
        }
        return true;
    }
    private static int num(String s1, String s2) {
        int count = 0;
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            String s  = s1.substring(0, i) + s2 + s1.substring(i, len);
            if (reverse(s)) {
                count++;
            }
        }
        String s = s1 + s2;
        if (reverse(s)) {
            count++;
        }
        return count;
    }
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            int count = num(s1, s2);
            System.out.println(count);
        }
    }

    public static void main2(String[] args) {
        String s = "abcdef";
        System.out.println(s.substring(0,0)); // [ , );子字符串
    }

    public static void main1(String[] args) {
        /*System.out.println(100 % 3);
        System.out.println(100 % 3.0);
        System.out.println(10%(-3));
        System.out.println(Math.round(11.5));
        System.out.println(Math.round(-11.5));
        System.out.println(Math.round(5.5));*/

        String s = "a,b,c";
        s = s + 'a';
        System.out.println(s);
    }
}
