import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int num = (int)Math.pow(n, 2);
            System.out.println(num);
            String str = String.valueOf(num);
            if (str.substring(1).equals(n + "")) {
                System.out.println("Yes!");
            }else {
                System.out.println("No!");
            }

        }
    }
}
