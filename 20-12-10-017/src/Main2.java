import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
//            if ((n << 1) + 1 == 1000000007) {
//                System.out.println("-1");
//                return;
//            }
            int count = 0;
            while (n != 0 && count <= 300000) {
                n = ((n << 1) + 1) % 1000000007;
                count++;
            }
            //int res = (count + 2) / 3;
            int res = count % 3 == 0 ? count/3 : count/3 + 1;
            System.out.println(res > 100000 ? -1 : res);
        }
    }
}
