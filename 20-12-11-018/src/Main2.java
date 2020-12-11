import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int T = sc.nextInt(); // 组数
           List<List<Integer>> lists = new ArrayList<>();
            for (int i = 0; i < T; i++) {
                int n = sc.nextInt();
                int k = sc.nextInt(); // 每组洗牌洗牌的次数
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < 2*n; j++) {
                    list.add(sc.nextInt());
                }
                //System.out.println(list);
                // 洗牌
                for (int j = 0; j < k; j++) {
                    List<Integer> midList = new ArrayList<>();
                    for (int l = 0; l < n; l++) {
                        midList.add(list.get((2 * n - 1) - l));
                        midList.add(list.get((n - 1) - l));
                    }
                    //System.out.println("midList : " + midList);
                    for (int l = 0; l < 2 * n ; l++) {
                        list.set(l, midList.get((2 * n - 1) - l));
                    }
                }
                lists.add(list);
            }
            System.out.println(lists);
            for (int i = 0; i < T; i++) {
                for (int j = 0; j < lists.get(i).size(); j++) {
                    System.out.print(lists.get(i).get(j));
                    if (j != lists.get(i).size() - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
