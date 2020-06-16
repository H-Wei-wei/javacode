import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            String ret = GetSequeOddNum(m);
            System.out.println(ret);
        }
    }
    private static String GetSequeOddNum(int m) {
        int n = m * (m - 1) + 1; // 结果中的第一个奇数
        String ret = n + "";
        while ((m - 1) > 0) {
            n = n + 2;
            ret = ret + "+"+ n;
            m--;
        }
        return ret;
    }
}
