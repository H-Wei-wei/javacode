import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int count = 0;
            while (n > 0) {
                count += n /5;
                n = n / 5;
            }
            System.out.println(count);
        }
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt(); // [1, 1000]
            long fax = 1; // 范围不够，此方法不能够通过所有要求得 n
            for (int i = 1; i <= n; i++) {
                 fax = fax * i;
            }
            System.out.println(fax);
            int count = 0;
            while (fax > 9) {
                if (fax % 10 == 0) {
                    count++;
                    fax = fax / 10;
                }else {
                    break;
                }
            }
            System.out.println(count);
        }
    }
}
