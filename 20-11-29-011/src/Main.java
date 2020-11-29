import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int A = 0;
            int B = 0;
            int C = 0;
            int num1 = sc.nextInt(); // A - B
            int num2 = sc.nextInt(); // B - C
            int num3 = sc.nextInt(); // A + B
            int num4 = sc.nextInt(); // B + c
            A = (num1 + num3)/2;
            B = (num3 - num1)/2;
            C = (num4 - num2)/2;
            int  B2 = (num2 + num4)/2;
            if (B != B2) {
                System.out.println("No");
            }else {
                System.out.println(A + " " + B + " " + C);
            }
        }
    }
}
