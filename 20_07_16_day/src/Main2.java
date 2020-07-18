
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int left = 0;
            int right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                }else if (s.charAt(left + 1) == s.charAt(right)) {
                    left++;
                }else if (s.charAt(left) == s.charAt(right + 1)) {
                    right++;
                }else {
                    System.out.println("NO");
                    break;
                }

            }
        }
    }
}
