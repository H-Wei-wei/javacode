import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String str = GetSequeOddNum(n);
            System.out.print(str);
        }
    }
    public static String GetSequeOddNum(int n) {
        int m = n * (n - 1) + 1;
        int ret = 0;
        int ans = m;
        String answer = "";
        for (int i =0;i < n;i++) {
            ret += m;
            m+=2;
        }
        if (Math.pow(n,3)==ret) {
            for (int j = 0;j < n-1;j++){
                answer = answer + ans + "+";
                ans+=2;
            }
            return answer + ans;
        }
        return null;
    }
}