import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[4];
        while (sc.hasNext()) {
            for (int i = 0; i < 4; i++) {
                int x = sc.nextInt();
                array[i] = x;
            }
            System.out.println(func(array));
        }
    }

    private static String func(int[] array) {
        int A = (array[0] + array[2]) / 2;
        int B = (array[1] + array[3]) / 2;
        int C = (array[3] - array[1]) / 2;
        if ( (A - B != array[0]) || (B - C != array[1])
                || (A + B != array[2]) || (B+ C != array[3])) {
            return "No";
        }
        return (A +" "+ B + " " + C);
    }
}
