import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] split = s.split(" ");
            int[] array = new int[split.length];
            for(int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(split[i]);
            }
            String ret = func(array);
            System.out.println(ret);
        }
    }
    private static String func(int[] array) {
        String ret = "";
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] != 0) {
                count = count + array[i];
            }
        }
        int[] a = new int[count];
        int b = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                while (array[i] != 0 ) {
                    a[b++] = i;
                    array[i]--;
                }
            }
        }
        Arrays.sort(a);
        if (a[0] == 0) {
            for (int i = 1; i < count; i++) {
                if (a[i] != 0) {
                    swap(a, 0, i);
                    break;
                }
            }
        }
        for (int i = 0; i < count; i++) {
            ret = ret + a[i];
        }
        return ret;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
