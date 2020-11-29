import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] array = s.split(" ");
            for (int i = 0; i < array.length; i++) {
                int count = 1;
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i].equals(array[j])) {
                        count++;
                    }
                }
                if (count >= array.length/2) {
                    System.out.println(array[i]);
                    break;
                }
            }
        }
    }
}
