import java.util.Scanner;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" +
                start +
                ","+ end +
                ']';
    }
}

public class TestDemo2 {
    public static Interval solve (int n, int k, String str1, String str2) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (c1 == c2) {
                count++;
            }
        }
        if (count == n) {
            return new Interval(count,n);
        }
        return new Interval(count, n - k);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String str1 = sc.next();
            String str2 = sc.next();
            Interval interval = solve(n, k, str1, str2);
            System.out.println(interval);
        }
    }
}
