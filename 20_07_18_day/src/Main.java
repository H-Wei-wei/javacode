import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int[] ret = oneNum(arr);
            Arrays.sort(ret);
            for (int x: ret) {
                System.out.print(x + " ");
            }
        }
    }

    private static int[] oneNum(int[] arr) {
        int num = 0;
        for (int x: arr) {
            num = num ^ x;
        }
        int bit = 0;
        for (; bit < 32; bit++) {
            if ((num & (1 << bit)) > 1) {
                break;
            }
        }
        int a = 0;
        int b = 0;
        for (int x: arr) {
            if ((x & (1 << bit)) > 0) {
                a = a ^ x;
            } else {
                b = b ^ x;
            }
        }
        return new int[]{a, b};
    }
}
