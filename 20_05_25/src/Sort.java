
public class Sort {
    // 快速排序查找第K大元素
    public int findKth(int[] a, int n, int K) {
        if (K > n) {
            return -1;
        }
        findKthHelper(a, 0, n - 1);
        return a[K - 1];
    }

    private void findKthHelper(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(a, left, right);
        findKthHelper(a, left, index - 1);
        findKthHelper(a, index + 1, right);
    }

    private int partition(int[] a, int left, int right) {
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
            swap(a, i, j);
        }
        swap(a, i, right);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] a = {3,6,9,7,9,2,5,8};
        //tree.findKthHelper(a, 0 , a.length - 1);
        int ret = sort.findKth(a, a.length, 3);
        System.out.println(ret);
    }
}
