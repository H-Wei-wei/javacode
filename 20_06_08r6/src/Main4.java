import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] split = s.split(" ");
            int[] array = new int[split.length - 1];
            for (int i = 0; i < split.length - 1; i++) {
                array[i] = Integer.parseInt(split[i]);
            }
            int K = Integer.parseInt(split[split.length - 1]);
            func(array, K);
        }
    }

    private static void func(int[] array, int k) {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < k; i++) {
            System.out.print(array[i]);
            if (i < k - 1) {
                System.out.print(" ");
            }
        }
    }
}
