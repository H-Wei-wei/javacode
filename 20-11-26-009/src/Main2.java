import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(func(n));
        }
    }

    private static int func(int n) {
        int count = 0;
        if (n < 6 || n % 2 != 0 || n == 10) {
            return -1;
        }
        if (n % 8 == 0) {
            count = n/8;
        }else {
            count = n/8 + 1;
        }
       return count;
    }
}
