import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int count = 0;
            for (int i = 0; i <= n - m; i++) {
                boolean flg = false;
                for (int j = i; j < i + m; j++) {
                    if (arr[j] < k) {
                        flg = true;
                        break;
                    }
                }
                if (!flg) {
                    count++;
                }
            }
            //count++;
            System.out.println(count);
        }
    }
}
