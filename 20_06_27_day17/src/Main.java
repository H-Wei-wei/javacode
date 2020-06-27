import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String sell = sc.nextLine();
            String buy = sc.nextLine();
            char[] s = sell.toCharArray();
            char[] b = buy.toCharArray();
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < s.length; i++) {
                list.add(s[i]);
            }
            int count = 0;// 表示有的字符
            for (int i = 0; i < b.length; i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (b[i] == list.get(j)) {
                        count++;
                        list.remove(j);
                        break;
                    }
                }
            }
            if (count == b.length) {
                System.out.println("Yes " + (s.length - count));
            } else {
                System.out.println("No " + (b.length - count));
            }
        }
    }
}

