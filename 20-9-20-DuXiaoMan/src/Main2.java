import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = sc.next();
            }
            int gap = 3;
            int count = 0;
            for (int i = 0; i < n; i++) {
                String s = strings[i];
                for (int j = gap; j < s.length(); j++) {
                    if (s.charAt(j) == s.charAt(j-gap)) {
                        count++;
                    }
                }
                if (count >= 2*(s.length()/3 - 1)) {
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }
            }
        }
    }
}
