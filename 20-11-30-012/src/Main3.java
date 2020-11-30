import java.util.Scanner;

public class Main3 {
    static int n;
    static int[] array;
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            n = sc.nextInt();
            array = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                array[i] = sc.nextInt();
            }
            count(40, n);
            System.out.println(count);
        }
    }

    // s 表示还有多少没装满
    private static void count(int s, int n) {
        //正好装满
        if (s == 0) {
            ++count;
            return;
        }
        if(s < 0 || (s > 0 && n < 1)) {
            return;
        }
        count(s - array[n], n - 1);
        count(s, n - 1);
    }
}
