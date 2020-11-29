import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int max = 0;
            String res = "";
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                int count = 0;
                if (c > '0' && c < '9') {
                    String ret = "";
                    for (int j = i; j < str.length(); j++) {
                        if (str.charAt(j) < '0' || str.charAt(j) > '9'){
                            break;
                        }
                        count++;
                        ret += str.charAt(j);
                        if (count > max) {
                            max = count;
                            res = ret;
                        }
                    }
                }
            }
            System.out.println(res);
        }
    }
}
