
import java.math.BigInteger;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            BigInteger[] b = new BigInteger[n];
            List<BigInteger> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextBigInteger();
                list.add(b[i]);
            }
            Collections.sort(list);
            for (BigInteger x: list) {
                System.out.println(x);
            }
        }
    }
}
