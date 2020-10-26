import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.print(n + "=");
            int i = 0;
            for(i = 2; i < n; i++) {
                while(n != i) {
                    if (n%i == 0) {
                        System.out.print(i + "*");
                        n = n/i;
                    }else {
                        break;
                    }
                }
            }
            System.out.println(n);
        }
    }
}
