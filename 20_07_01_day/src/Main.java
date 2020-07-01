import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.print(func(n) + " " + func(n * n));
        }
    }

    private static int func(int n) {
        if (n < 10) {
            return n;
        }
        return func(n/10) + n % 10;// 每一位之和
    }
}
