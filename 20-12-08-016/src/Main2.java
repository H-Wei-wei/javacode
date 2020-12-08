import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String s = getSequeOddNum(n);
            System.out.println(s);
        }
    }

    private static String getSequeOddNum(int n) {
        String ret = "";
        int num = (n * (n - 1) + 1);
        ret += num ;
        for (int i = 0; i < n - 1; i++) {
            if (i != n - 1) {
                ret += "+";
            }
            num = num + 2;
            ret += num;
        }
        return ret;
    }
}
