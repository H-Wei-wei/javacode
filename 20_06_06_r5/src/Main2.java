import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while (sc.hasNext()) {
            String dataStr = sc.nextLine();
            String[] split = dataStr.split(" ");
            int[] array = new int[split.length];
            for (int i = 0; i < array.length; i ++) {
                array[i] = Integer.parseInt(split[i]);
            }
            Arrays.sort(array);
            System.out.println(array[(array.length - 1)/ 2]);
        }

    }

    private static Integer func(int[] array, int n) {
        int count = 0;
        for (int bound = 0; bound < array.length; bound++) {
            count = 1;
            for (int cur = bound + 1; cur < array.length; cur++) {
                if (array[bound] == array[cur]) {
                    count++;
                    if (count >= n/2) {
                        return array[bound];
                    }
                }
            }
        }
        return null;
    }
}
