
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int count = 1;
            double x = 0;
            double sum = n - n/2;
            while (true) {
                count++;
                x = x + n/(Math.pow(2, count));
                sum = sum + (n - x);
                if (sum >= (100 * m))  {
                    break;
                }
            }
            System.out.println(count);
        }
    }
}
