
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = sc.nextInt();
            }
            for (int i = 0; sc.hasNext() && i < M; i++) {
                String c = sc.next();
                int A = sc.nextInt();
                int B = sc.nextInt();
                func(array, c, A, B);
            }
        }
    }

    private static void func(int[] array, String c, int A, int B) {
        if (c.equals("Q")) {
            int max = 0;// 用来存放 [A, B] 间最大值的
            if(A >= B){        //判断AB大小
                int n = B;
                B = A;
                A = n;
            }
            for (int j = A - 1; j < B; j++) {
                max = Math.max(array[j], max);
            }
            System.out.println(max);
        } else if (c.equals("U")) {
            array[A - 1] = B;
        }
    }
}
