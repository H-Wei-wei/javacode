import java.util.Scanner;

public class TestDemo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String s = sc.next();
            // 行数
            int row = n%2 == 0 ? n/2 : n/2 + 1;
            //System.out.println(row);
            for (int i = 0; i < row; i++) {
                // 第一行
                if (i == 0) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(s);
                    }
                    System.out.println();
                    continue;
                }
                if (i == row - 1) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(s);
                    }
                    System.out.println();
                    break;
                }
                System.out.print(s);
                for (int j = 1; j < n - 1; j++) {
                    System.out.print(" ");
                }
                System.out.println(s);
                //System.out.println();
            }
        }
    }
}
