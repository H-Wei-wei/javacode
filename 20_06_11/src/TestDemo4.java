import java.util.*;

public class TestDemo4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x = sc.nextInt();// 行
            int y = sc.nextInt();// 列
            int ret = func(x, y);
            System.out.println(ret);
        }
    }

    public static int func(int x, int y) {
        int ret = 0;
        // 第一组一行
        int m = (y/4) * 2 + (y % 4 < 2 ? y%4 : 2);
        // 第二组一行
        int n = ((y - 2)/4) * 2 + ((y - 2) % 4 < 2 ? (y-2)%4 : 2);
        ret = x/4 * (m + n) * 2;
        if (x % 4 > 0) {
            ret += m;
        }
        if (x % 4 > 1) {
            ret += m;
        }
        if (x % 4 > 2) {
            ret += n;
        }
        return ret;
    }

}
