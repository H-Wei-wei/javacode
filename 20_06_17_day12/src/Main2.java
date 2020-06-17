import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int K = sc.nextInt();
            int[] array = new int[2 * n]; // 长度肯定为偶数
            for (int i = 0; i < 2 * n; i++) {
                array[i] = sc.nextInt();
            }
            System.out.println();
            // 洗牌
            int[] ret = shuffleCards(K, array);
            // 按格式输出
            for (int i = 0; i < ret.length; i++) {
                System.out.print(ret[i]);
                if (i != ret.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            T--;
        }
    }

    private static int[] shuffleCards(int K, int[] array) {
        int[] ret = new int[array.length];
        while (K > 0) {
            int mid = array.length / 2; // 下一半牌第一张牌的下标
            int cur1 = mid - 1;
            int cur2 = array.length - 1;
            for (int i = array.length - 1; i > 0; i -= 2) {
                ret[i] = array[cur2];
                ret[i - 1] = array[cur1];
                cur1--;
                cur2--;
            }
            for (int i = 0; i < ret.length; i++) {
                array[i] = ret[i];
            }
            K--;
        }
        return ret;
    }
}