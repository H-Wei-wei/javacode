import java.util.Arrays;

public class Exam {
    // 找第 K 大的值
    public static int findKth(int[] a, int n, int K) {
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < n; i++) {
            if (K == n - i) {
                return a[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,4,6,8,3,9};
        System.out.println(findKth(array, 6, 2));
    }
}
