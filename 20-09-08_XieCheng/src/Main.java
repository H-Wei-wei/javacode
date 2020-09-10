import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String[] strings1 = str1.split(" ");
        int[] array1 = new int[strings1.length];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = Integer.parseInt(strings1[i]);
        }
        String str2 = sc.nextLine();
        String[] strings2 = str2.split(" ");
        int[] array2 = new int[strings2.length];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = Integer.parseInt(strings2[i]);
        }
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        int count = func(array1, array2);
        System.out.println(count);
    }

    private static int func(int[] array1, int[] array2) {
        int count = 0;
        int tmp = 0;
        for (int i = 0; i < array2.length; i++) {
            int j = tmp;
            for (; j < array1.length; j++){
                if (array2[i] >= array1[j]) {
                    count++;
                    tmp++;
                    break;
                }
            }
        }
        return count;
    }
}
