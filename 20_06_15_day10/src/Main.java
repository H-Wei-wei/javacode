import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] split = s.split(" ");
            int n = Integer.parseInt(split[0]);
            //char c = s.charAt(1);
            // 第一行
            for (int i = 0; i < n; i++) {
                System.out.print(split[1]);
            }
            System.out.println(); // 换行

            // 确定一列中字母的个数
            // 因为列字母数是行字母数的 50% （四舍五入）
            // 行字母有偶数个，中间列字母数就有（n / 2 - 2）个
            // ······· 奇数个，···············（n / 2 - 1）个
            int col = 0;
            if (n % 2 == 0) {
                col = n / 2 - 2;
            }else  {
                col = n / 2 - 1;
            }
            // 布局中间的字母块
            while (col > 0) {
                for(int i = 0; i < n; i++) {
                    if (i == 0 || i == n - 2) {
                        System.out.print(split[1]);
                    }
                    System.out.print(" ");
                }
                // 换行
                System.out.println();
                col--;
            }

            // 最后一行
            for (int i = 0; i < n; i++) {
                System.out.print(split[1]);
            }
            System.out.println();
        }
    }
}
