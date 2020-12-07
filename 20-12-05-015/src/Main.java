import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String res = AddLongInteger(s1, s2);
            for (int i = res.length() - 1; i >= 0; i--) {
                System.out.print(res.charAt(i));
            }
            System.out.println();
        }
    }

    private static String AddLongInteger(String s1, String s2) {
        String ret = "";
        int len1 = s1.length();
        int len2 = s2.length();
        String zerosS = "";
        if (len1 < len2) {
            for (int i = 0; i < len2 - len1; i++) {
                zerosS += "0";
            }
            s1 = zerosS + s1;
        }else if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                zerosS += "0";
            }
            s2 = zerosS + s2;
        }
        // 表示进位
        int car = 0;
        for (int i = s1.length() - 1; i >= 0; i--) {
            // 当前计算的位
            int n1 = Integer.parseInt(s1.charAt(i) + "");
            int n2 = Integer.parseInt(s2.charAt(i) + "");
            // 计算
            int n = n1 + n2 + car;
            if (n > 9) {
                car = 1;
                n = n % 10;
            }else {
                car = 0;
            }
            ret += n + "";
        }
        if (car != 0) {
            ret += car;
        }
        return ret;
    }
}
