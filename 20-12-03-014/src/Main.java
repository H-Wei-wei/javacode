import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int f1 = 0;
            int f2 = 1;
            int f3 = f1 + f2;
            while (f3 <= n) {
                f1 = f2;
                f2 = f3;
                f3 = f1 + f2;
            }
            //System.out.println("f2 = " + f2 + "   f3 = " + f3);
            // 此时 f2 就是小于 n 且距离 n 最近的斐波那契额数
            // f3 就是大于 n 的第一个斐波那契额数
            System.out.println(Math.min(f3 - n, n - f2));
        }
    }
}
