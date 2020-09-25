
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String S = sc.next();
            String T = sc.next();
            int count = 0;
            StringBuilder sb = new StringBuilder(T);
            for (int i = 0; i < S.length(); i++) {
                for (int j = 0; j < sb.length(); j++) {
                    char c = S.charAt(i);
                    if (c == sb.charAt(j)) {
                        count++;
                        sb.deleteCharAt(j);
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }
}

