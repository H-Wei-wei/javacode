import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int count = 0;
            for (int i = n; i >= 5 ; i--) {
                int tmp = i;
                while (tmp%5 == 0) {
                    count++;
                    tmp /= 5;
                }
            }
            System.out.println(count);
        }
    }

}