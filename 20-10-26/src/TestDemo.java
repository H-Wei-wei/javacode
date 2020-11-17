import java.util.Arrays;

public class TestDemo {
    public static void JZT() {
        int n = 2;

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i = 0; i < n + 1; i++) {
            System.out.print("* ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length -1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public static void insertSort(int[] array) {
        for (int bound = 1; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound - 1;
            for (; cur >= 0  ; cur--) {
                if (array[cur] > tmp) {
                    array[cur + 1] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
    }

    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = bound; cur < array.length; cur++) {
                if (array[cur] < array[bound]) {
                    int tmp = array[cur];
                    array[cur] = array[bound];
                    array[bound] = tmp;
                }
            }
        }
    }

    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(array, left, right);
        quickSortHelper(array, left, index - 1);
        quickSortHelper(array, index + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int baseValue = array[right];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && array[i] <= baseValue) {
                i++;
            }
            while (i < j && array[j] >= baseValue) {
                j--;
            }
            swap(array, i, j);
        }
        swap(array, i, right);
        return i;
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void mergeSort(int[] array) {
        mergeSortHelper(array,0, array.length);
    }

    private static void mergeSortHelper(int[] array, int left, int right) {
        if (right - left <= 1) {
            return;
        }
        int mid = (left + right)/2;
        mergeSortHelper(array, left, mid);
        mergeSortHelper(array, mid, right);
        merge(array, left, right, mid);
    }

    private static void merge(int[] array, int left, int right, int mid) {
        int cur1 = left;
        int cur2 = mid;
        int[] res = new int[right - left];
        int index = 0;
        while (cur1 < mid && cur2 < right) {
            // 等号作用：保持稳定性
            if (array[cur1] <= array[cur2]) {
                res[index] = array[cur1];
                cur1++;
                index++;
            }else {
                res[index] = array[cur2];
                cur2++;
                index++;
            }
        }
        while (cur1 < mid) {
            res[index] = array[cur1];
            cur1++;
            index++;
        }
        while (cur2 < right) {
            res[index] = array[cur2];
            cur2++;
            index++;
        }
        for (int i = 0; i < res.length; i++) {
            array[left + i] = res[i];
        }
    }

    public static void binarySearch() {

    }

    public static void main(String[] args) {
        int[] array = {4,2,6,7,8,9,10,3,1};
        //bubbleSort(array);
        //insertSort(array);
        //selectSort(array);
        //quickSort(array);
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
