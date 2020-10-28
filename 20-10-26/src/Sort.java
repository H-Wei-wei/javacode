import java.util.Arrays;

public class Sort {
    // 选择排序 ------ 稳定排序 时间复杂度 O(n^2) 空间复杂度 O(1)
    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int i = bound + 1; i < array.length; i++) {
                if (array[bound] > array[i]) {
                    swap(array, bound, i);
                }
            }
        }
    }

    // 插入排序 --- 
    public static void insertSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            int tmp = array[bound];
            int i = bound - 1;
            for (; i >= 0 ; i--) {
                if (array[i] > tmp) {
                    array[i + 1] = array[i];
                }else {
                    break;
                }
            }
            array[i + 1] = tmp;
        }
    }

    // 希尔排序
    public static void shellSort(int[] array) {
        int gap = array.length/2;
        while (gap >= 1) {
            shellSortHelper(array,gap);
            gap /= 2;
        }
    }

    private static void shellSortHelper(int[] array, int gap) {
        for (int bound = gap; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound - gap;
            for (;cur >= 0; cur -= gap) {
                if (array[cur] > tmp) {
                    array[cur + gap] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + gap] = tmp;
        }
    }

    // 堆排序
    public static void heapSort(int[] array) {
        createHeap(array);
        int len = array.length;
        while (len > 0) {
            swap(array, 0, len - 1);
            len--;
            downShift(array, len, 0);
        }
    }

    private static void downShift(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size && array[child] < array[child + 1]) {
                child = child + 1;
            }
            if (array[child] > array[parent]) {
                swap(array, child, parent);
            }else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    private static void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1)/2; i >= 0 ; i--) {
            downShift(array, array.length, i);
        }
    }

    private static void swap(int[] array, int bound, int i) {
        int tmp = array[bound];
        array[bound] = array[i];
        array[i] = tmp;
    }

    // 冒泡排序
    public static void bubbleSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = 0; cur < array.length - bound - 1; cur++) {
                if (array[cur] > array[cur + 1]) {
                    swap(array, cur, cur + 1);
                }
            }
        }
    }

    // 快排
    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(array, left, right);
        quickSortHelper(array,0, index - 1);
        quickSortHelper(array, index + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int baseValue = array[right];
        int i = right;
        while (left < right) {
            while (left < right && array[left] <= baseValue) {
                left++;
            }
            while (left < right && array[right] >= baseValue) {
                right--;
            }
            if (left < right) {
                swap(array, left, right);
            }
        }
        swap(array, left, i);
        return left;
    }

    public static void mergeSort(int[] array) {
        mergeSortHelper(array, 0, array.length);
    }

    private static void mergeSortHelper(int[] array, int left, int right) {
        if (right - left <= 1) {
            return;
        }
        int mid = (right + left)/2;
        mergeSortHelper(array, left, mid);
        mergeSortHelper(array, mid, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int cur1 = left;
        int cur2 = mid;
        int[] arr = new int[right - left];
        int size = 0;
        while (cur1 < mid && cur2 < right) {
            if (array[cur1] <= array[cur2]) {
                arr[size] = array[cur1];
                cur1++;
                size++;
            }else {
                arr[size] = array[cur2];
                cur2++;
                size++;
            }
        }
        while (cur1 < mid) {
            arr[size] = array[cur1];
            cur1++;
            size++;
        }
        while (cur2 < right) {
            arr[size] = array[cur2];
            cur2++;
            size++;
        }
        for (int i = 0; i < size; i++) {
            array[i + left] = arr[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {2,6,7,9,3,1,0,4,5};
        //selectSort(array);
        //insertSort(array);
        //shellSort(array);
        //heapSort(array);
        //bubbleSort(array);
        //quickSort(array);
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
