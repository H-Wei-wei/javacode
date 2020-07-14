import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int len_max = 0; // 最长的木棍长度
        List<Integer> list = new LinkedList<>();
        while (n > 0) {
            int i = sc.nextInt();
            int L = sc.nextInt();
            if (i == 1) {
                list.add(L);
                sum += L;
            }
            if (i == 2) {
                list.remove(list.indexOf(L));
                sum -= L;
            }
            Collections.sort(list);
            if (list.size() > 0) {
                len_max = list.get(list.size() - 1);
            }
            if (sum - len_max > len_max) {
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
            n--;
        }
    }
}
