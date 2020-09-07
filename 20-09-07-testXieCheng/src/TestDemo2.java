import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TestDemo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            int n = random.nextInt(11);
            array[i] = n;
        }
        Sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private static void Sort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound - 1;
            for (; cur >= 0; cur--) {
                if (array[cur] > tmp) {
                    array[cur + 1] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
    }
}
