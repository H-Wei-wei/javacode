import java.util.Arrays;

public class MySort {
    // 插入排序
    public static void insertSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound - 1;
            for (; cur >= 0 ; cur--) {
                if (array[cur] > tmp) {
                    array[cur + 1] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
    }

    // 希尔排序
    public static void shellSort(int[] array) {
        int gap = array.length/2;
        while (gap >= 1) {
            insertSortGap(array,gap);
            gap /= 2;
        }
    }
    private static void insertSortGap(int[] array, int gap) {
        for (int bound = gap; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound - gap;
            for (; cur >= 0 ; cur -= gap) {
                if (array[cur] > tmp) {
                    array[cur + gap] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + gap] = tmp;
        }
    }

    //选择排序
    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = bound + 1; cur < array.length; cur++) {
                if (array[bound] > array[cur]) {
                    swap(array, bound, cur);
                }
            }
        }
    }
    private static void swap(int[] array, int bound, int cur) {
        int tmp = array[bound];
        array[bound] = array[cur];
        array[cur] = tmp;
    }

    // 堆排序
    public static void heapSort(int[] array) {
        createHeap(array);
        int len = array.length;
        while (len > 0) {
            swap(array, len - 1, 0);
            len--;
            shiftDown(array, len, 0);
        }
    }
    private static void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1)/2; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }
    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2*parent + 1;
        while (child < size) {
            if (child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if (array[child] > array[parent]) {
                swap(array, child, parent);
            }else {
                break;
            }
            parent = child;
            child = 2*parent + 1;
        }
    }

    // 冒泡排序
    public static void bubbleSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = 0; cur < array.length - 1 - bound; cur++) {
                if (array[cur] > array[cur + 1]) {
                    swap(array, cur, cur + 1);
                }
            }
        }
    }

    // 快速排序
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
            if (i < j) {
                swap(array, i, j);
            }
        }
        swap(array, i, right);
        return i;
    }

    // 归并排序
    public static void mergeSort(int[] array) {
        mergeSortHelper(array, 0, array.length);
    }
    private static void mergeSortHelper(int[] array, int left, int right) {
        if (right - left <= 1) {
            return;
        }
        int mid = (left + right)/2;
        mergeSortHelper(array, left, mid);
        mergeSortHelper(array, mid, right);
        merge(array, left, mid, right);
    }
    private static void merge(int[] array, int left, int mid, int right) {
        int cur1 = left;
        int cur2 = mid;
        int[] result = new int[right - left];
        int index = 0;
        while (cur1 < mid && cur2 < right) {
            if (array[cur1] <= array[cur2]) {
                result[index] = array[cur1];
                index++;
                cur1++;
            }else {
                result[index] = array[cur2];
                index++;
                cur2++;
            }
        }
        while (cur1 < mid) {
            result[index] = array[cur1];
            index++;
            cur1++;
        }
        while (cur2 < right) {
            result[index] = array[cur2];
            index++;
            cur2++;
        }
        for (int i = 0; i < index; i++) {
            array[left + i] = result[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {5,3,7,2,4,6,8,1,9};
        //insertSort(array);
        //shellSort(array);
        //selectSort(array);
        heapSort(array);
        //bubbleSort(array);
        //quickSort(array);
        //mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
