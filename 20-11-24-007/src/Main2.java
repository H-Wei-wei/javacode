import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int res = func(n);
            if (res == 0) {
                System.out.println();
                continue;
            }
            System.out.println(res);
        }
    }

    private static int func(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        // 可以换来的水
        int water = n / 3;
        // 此时空瓶子数
        int bottle = n % 3 + water;
        if(bottle == 2) {
            bottle = bottle + 1;
        }
        return water + func(bottle);
    }
}
