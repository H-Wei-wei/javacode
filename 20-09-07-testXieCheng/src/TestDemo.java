import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            String res = "";
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c <= 'z' && c >= 'A' ) {
                    res += c;
                    continue;
                }
                if (c == '['  || c == ']' || c == '\\' || c == '_' || c == '\'' || c == '^') {
                    res += c;
                }
                if ( c == '$' ) {
                    c = '^';
                    res += c;
                }
            }
            System.out.println(res);
        }
    }
}
