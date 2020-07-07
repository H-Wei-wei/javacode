import java.util.Arrays;

public class Main {
    public static void mergeQuick(int[] array) {
        mergeQuickHelper(array, 0, array.length);
    }

    private static void mergeQuickHelper(int[] array, int left, int right) {
        if (right - left <= 1) {
            return;
        }
        int mid = (left + right) / 2;
        mergeQuickHelper(array, left, mid);
        mergeQuickHelper(array, mid, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int cur1 = left;
        int cur2 = mid;
        int[] outPut = new int[right - left];
        int outPutIndex = 0;
        while (cur1 < mid && cur2 < right) {
            if (array[cur1] <= array[cur2]) {
                outPut[outPutIndex] = array[cur1];
                outPutIndex++;
                cur1++;
            }else {
                outPut[outPutIndex] = array[cur2];
                outPutIndex++;
                cur2++;
            }
        }
        while (cur1 < mid) {
            outPut[outPutIndex] = array[cur1];
            outPutIndex++;
            cur1++;
        }
        while (cur2 < right) {
            outPut[outPutIndex] = array[cur2];
            outPutIndex++;
            cur2++;
        }
        for (int i = 0; i < outPutIndex; i++) {
            array[left + i] = outPut[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {5,6,3,2,6,8,9,3,1,3,4};
        mergeQuick(array);
        System.out.println(Arrays.toString(array));
    }
}
