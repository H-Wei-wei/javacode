import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            int score = sc.nextInt();
            int count = 0;
            for (int x: array) {
                if (x == score) {
                    break;
                }
            }
            System.out.println(score);
        }
    }
}