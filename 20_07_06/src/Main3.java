
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        for(int i = split.length-1; i >= 0; i--){
            System.out.print(split[i]);
            if (i > 0) {
                System.out.print(" ");
            }
        }
    }
}
