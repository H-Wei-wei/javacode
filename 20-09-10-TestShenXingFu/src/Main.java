import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            int n = sc.nextInt();
            String[] strings = str.split("");
            int[] array = new int[strings.length];
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(strings[i]);
            }
            boolean flg = false;
            if (array.length == 8 && (n <= 8 && n >= 1)) {
                for (int i = 0; i < 8; i++) {
                    if (!(array[i] <= 9 && array[i] >= 0)) {
                        System.out.println("error");
                        flg = true;
                        break;
                    }
                }
                if(!flg) {
                    func(array, n);
                }
            }else {
                System.out.println("error");
            }
        }
    }

    private static void func(int[] array, int n) {
        String str = "";
        int[] ret = new int[7];
        int index = 0;
        for (int i = 0; i < 8; i++) {
            if (i != (n - 1)) {
                ret[index] = array[i];
                index++;
            }
        }
        Arrays.sort(ret);
        for (int i = 6; i >= 0; i--) {
            str += ret[i];
        }
        System.out.println(str);
    }
}
