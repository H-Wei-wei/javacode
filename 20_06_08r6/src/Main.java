import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int s1 = sc.nextInt();
            int s2 = sc.nextInt();
            int a = s1;
            int b = s2;
            int m = s1;
            while (m != 0) {
                m = s1 % s2;
                s1 = s2;
                s2 = m;
            }

            System.out.println((a / s1) * b);
        }
    }
}
