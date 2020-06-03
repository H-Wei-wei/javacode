
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            String ret = findNum(str, str.length());
            System.out.println(ret);
        }
    }

    private static String findNum(String str, int n) {
        String ret = "";    // 用来保存拼接的数字
        String cur = "";    // 用来保存数字最长的数字串
        String cur2 = "";
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                ret = ret + c;
                if (ret.length() > cur.length()) {
                    cur = ret;
                }else if (ret.length() == cur.length()) {
                    cur2 = ret;
                }
            }else {
                ret = "";
            }
        }
        if (cur2.length() == cur.length()) {
            System.out.print(cur2 + ",");
        }
        return cur;
    }
}
