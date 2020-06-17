import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = sc.nextInt();
            }
            int mScore = sc.nextInt();
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (array[i] == mScore) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}