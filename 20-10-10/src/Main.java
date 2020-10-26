import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int y1 = sc.nextInt();
            int m1 = sc.nextInt();
            int d1 = sc.nextInt();
            int w1 = sc.nextInt();
            int y2 = sc.nextInt();
            int m2 = sc.nextInt();
            int d2 = sc.nextInt();
            int y = y2 - y1;
            int m = m2 - m1;
            int d = d2 - d1;
            int w2 = 0;
            w2 = (y * 365 + m * 30 + d + w1) % 7 ;
            System.out.println(w2);
        }
    }
}
