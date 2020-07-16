import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                set.add(s.charAt(i));
            }
            int sum = 0;
            for (char c : set) {
                String str = s + c;
                int ret = isHuiWan(str);
                sum += ret;
                if (sum == 1) {
                    System.out.println("YES");
                    break;
                }
            }
            if (sum == 0) {
                System.out.println("NO");
            }
        }
    }

    private static int isHuiWan(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return 0;
            }
            left++;
            right--;
        }
        return 1;
    }


}
