import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(func(s1, s2));
        }
    }

    private static String func(String s1, String s2) {
        String ret = "";
        boolean flg = false;   // 标志位
        for (int i = 0; i < s1.length(); i++) {
            char tmp = s1.charAt(i);
            flg = false;
            for (int j = 0; j < s2.length(); j++) {
                if (tmp ==  s2.charAt(j)) {
                    flg = true;
                    break;
                }
            }
            if (flg) {
                continue;
            }
            ret = ret + tmp;
        }
        return ret;
    }
}