import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.next();
            String s2 = sc.next();
            s1 = s1.toUpperCase();
            s2 = s2.toUpperCase();
            Set<Character> set1 = new LinkedHashSet<>();
            for (int i = 0; i < s2.length(); i++) {
                set1.add(s2.charAt(i));
            }
            Set<Character> set2 = new LinkedHashSet<>();
            for (int i = 0; i < s1.length(); i++) {
                char c = s1.charAt(i);
                if (!set1.contains(c)) {
                    set2.add(c);
                }
            }
            for (char ch: set2) {
                System.out.print(ch);
            }
        }
    }
}
