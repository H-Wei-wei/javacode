import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String res = "";
            //String[] array = s2.split("");
            for (int i = 0; i < s2.length(); i++) {
                char c2 = s2.charAt(i);
                if (!res.equals("")) {
                    s1 = res;
                }
                res = "";
                for (int j = 0; j < s1.length(); j++) {
                    char c1 = s1.charAt(j);
                    if (c1 != c2) {
                        res += c1;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
