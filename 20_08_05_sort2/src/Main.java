import java.util.Arrays;

public class Main {
    public static void mergeSort(int[] array) {
        mergeSortHelper(array, 0, array.length);
    }

    private static void mergeSortHelper(int[] array, int left, int right) {
        if (right - left <= 1) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSortHelper(array, left, mid);
        mergeSortHelper(array, mid, right);
        merge(array, mid, left, right);
    }

    private static void merge(int[] array, int mid, int left, int right) {
        int cur1 = left;
        int cur2 = mid;
        int[] arr = new int[right - left];
        int arrSize = 0;
        while (cur1 < mid && cur2 < right) {
            if (array[cur1] <= array[cur2]) {
                arr[arrSize] = array[cur1];
                arrSize++;
                cur1++;
            }else {
                arr[arrSize] = array[cur2];
                arrSize++;
                cur2++;
            }
        }
        while (cur1 < mid) {
            arr[arrSize] = array[cur1];
            arrSize++;
            cur1++;
        }
        while (cur2 < right) {
            arr[arrSize] = array[cur2];
            arrSize++;
            cur2++;
        }
        for (int i = 0; i < arrSize; i++) {
            array[i + left] = arr[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {3,5,7,1,2,7,0,4,6,10};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
