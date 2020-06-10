import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static String s2 = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String n = sc.nextLine();
            String[] sArray = n.split(" ");
            int[] array = new int[sArray.length];
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(sArray[i]);
            }
            System.out.println(Arrays.toString(array));
            System.out.println(array.length);
        }
    }
}
