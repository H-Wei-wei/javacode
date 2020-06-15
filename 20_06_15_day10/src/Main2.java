
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String addEnd = sc.nextLine();
            String augEnd = sc.nextLine();
            String ret = AddLongInteger(addEnd,augEnd);
            System.out.println(ret);
        }
    }

    private static String AddLongInteger(String addEnd, String augEnd) {
        String str = "";
        int l1 = addEnd.length();
        int l2 = augEnd.length();
        if (l2 < l1) {
            for (int i = l1 - l2 - 1; i >= 0; i--) {
                augEnd = "0" + augEnd;
            }
        }else {
            for (int i = l2 - l1 - 1; i >= 0; i--) {
                addEnd = "0" + addEnd;
            }
            l1 = l2;
        }

        int last = 0;  // 进位
        int n = 0;  // 每一位的结果
        for (int i = l1 - 1; i >= 0; i--) {
            int a1 = addEnd.charAt(i) - '0'; //字符到数字
            int a2 = augEnd.charAt(i) - '0';
            int num = a1 + a2 + last;// 对应位的和
            if (num >= 10) {
                n = num % 10;
            }else {
                n = num;
            }
            str = n + str;
            last = num / 10;
        }
        if (last != 0) {
            str = last + str;
        }
        return str;
    }
}
