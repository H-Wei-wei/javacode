import java.util.Arrays;

public class TestDemo {

    public static int findKth(int[] a, int n, int K) {
        if (K > n && K <= 0) {
            return -1;
        }
        quickSort(a, 0, n - 1);
        return  a[K - 1];
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(a, left, right);
        quickSort(a, left, index - 1);
        quickSort(a, index + 1, right);
    }

    private static int partition(int[] a, int left, int right) {
        int baseValue = a[right];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && a[i] >= baseValue) {
                i++;
            }
            while (i < j && a[j] <= baseValue) {
                j--;
            }
            if (i < j) {
                swap(a,i, j);
            }
                    }
        swap(a, i, right);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {2,5,3,7,9,1,6};
        System.out.println(findKth(a, a.length, 3));
        System.out.println(Arrays.toString(a));
/*
        // 四舍五入
        System.out.println(Math.round(11.5));
        System.out.println(Math.round(11.4));
        System.out.println(Math.round(-11.5));
        System.out.println(Math.round(-11.4));
        System.out.println(Math.round(-11.8));
*/
    }
}
