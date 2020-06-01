
/**
 *  空瓶换水问题
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int emptyBottle = sc.nextInt();// 空瓶数
            if (emptyBottle == 0) {
                break;
            }
            System.out.println(empty(emptyBottle));
        }
    }
    private static int empty(int emptyBottle) {
        // 当空瓶小于 1 时，就返回 0  表示 没有的换
        if (emptyBottle <= 1) {
            return 0;
        }
        // 当前空瓶可以换的水；
        int cup = emptyBottle / 3;
        // 现在有的空瓶
        int e = cup + emptyBottle % 3;
        // 当还剩两空瓶时再借一瓶水
        if (e == 2) {
            e = e + 1;
        }
        return  cup + empty(e);
    }
}
