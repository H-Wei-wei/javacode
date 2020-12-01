import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] array = s.split(" ");
            int[] arr = new int[array.length - 1];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(array[i]);
            }
            int K = Integer.parseInt(array[array.length - 1]);
            Arrays.sort(arr);
            for (int i = 0; i < K; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
