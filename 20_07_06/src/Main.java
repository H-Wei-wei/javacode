 import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            char[] array = s.toCharArray();
            for (char c : array) {
                String num = Integer.toBinaryString(c);
                System.out.println(num);
                String str = String.format("%07d", Integer.parseInt(num));
                System.out.println(str);
                int count = 0;
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '1') {
                        count++;
                    }
                }
                System.out.println((count % 2 == 0) ? "1" +str : "0" + str);
            }
        }
    }
}