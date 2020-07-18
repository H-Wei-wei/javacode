import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext())  {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            func(array, n);
        }
    }

    private static void func(int[] array, int n) {
        int L = 0;
        int R = 0;
        for (int i = 0; i < n; i++) {
            int bound = i;
            while (true) {
                int index = --bound;
                if (index < 0) {
                    L = -1;
                    break;
                }
                if (array[index] < array[i]) {
                    L = index;
                    break;
                }
            }
            bound = i;
            while (true) {
                int index = ++bound;
                if (index >= n) {
                    R = -1;
                    break;
                }
                if (array[index] < array[i]) {
                    R = index;
                    break;
                }
            }
            System.out.println(L + " " + R);
        }
    }
}
