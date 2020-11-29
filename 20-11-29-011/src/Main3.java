import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            for (int i = 0; i < s1.length(); i++) {
                if (!s2.contains(s1.charAt(i) + "")) {
                    System.out.print(s1.charAt(i));
                }
            }
        }
    }
}
