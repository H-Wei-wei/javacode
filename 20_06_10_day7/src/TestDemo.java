import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int a = 0;
            int b = 1;
            int c = 1;
            int l1 = 0;
            int l2 = 0;
            while (true) {
                c = a + b;
                if (c < n) {
                    l1 = n - c;
                }else {
                    l2 = c - n;
                    break;
                }
                a = b;
                b = c;
            }
            System.out.println((l1 > l2 ? l2 : l1));
        }
    }
}

