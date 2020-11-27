import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(func(n));
        }
    }

    private static int func(int n) {
        int total = 0;
        while (n >= 3) {
            total = total + n/3;
            n = n / 3 + n % 3;
        }
        if (n == 2) {
            total = total + 1;
        }
        return total;
    }
}
