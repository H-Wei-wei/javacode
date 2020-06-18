import java.util.*;
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long x_0 = sc.nextInt();
            int  count = 0;
            while (x_0 != 0 && count <= 300000) {
                x_0 = ((x_0 << 1) + 1) % 1000000007;
                count++;
            }
            int result = (count + 2) / 3;
            System.out.println(result > 100000 ? -1 : result);
        }
    }
}