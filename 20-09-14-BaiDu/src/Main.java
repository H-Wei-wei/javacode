import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int max = sc.nextInt();
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            Arrays.sort(array);
            int sum = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                sum += array[i];
                if (sum > max) {
                    break;
                }
                count++;
            }
            System.out.println(count);
        }
    }
}
