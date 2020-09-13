import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int n = Integer.parseInt(s);
            String str = sc.nextLine();
            if (n >= str.length()) {
                for (int i = str.length() - 1; i >= 0 ; i--) {
                    System.out.print(str.charAt(i));
                }
            }else {
                int x = str.length()%n;
                for (int i = 0; i < str.length() - x; i += n) {
                    for (int j = i + n - 1; j >= i; j--) {
                        System.out.print(str.charAt(j));
                    }
                }
                for (int i = str.length() - 1; i > str.length() - 1 - x ; i--) {
                    System.out.print(str.charAt(i));
                }
            }
            System.out.println();
        }
    }
}
