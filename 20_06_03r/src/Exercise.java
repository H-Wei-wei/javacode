import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(func(n));
        }
    }

    private static int func(int n) {
        int count = 0;
        // 小于 6 个、奇数个苹果、 10 个苹果，不买
        if (n < 6 || n % 2 != 0 || n == 10 ) {
            return -1;
        }
        if (n % 8 == 0) {
            count = n / 8;
        }else {
            count = n / 8 + 1;
        }
        return count;
    }
}

