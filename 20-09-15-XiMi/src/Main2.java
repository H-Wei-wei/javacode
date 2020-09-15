import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            String s = sc.nextLine();
            sb.append(s);
        }
        System.out.println(sb);
    }
}

 