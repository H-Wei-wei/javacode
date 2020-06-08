import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int ret = finallyIndex(n);
            System.out.println(ret);;
        }
    }

    private static int finallyIndex(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int i = 0;
        while (list.size() > 1) {
            i = (i + 2) % list.size();
            list.remove(i);
        }
        return list.get(i);
    }
}
