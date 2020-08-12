import java.util.Arrays;

public class HeapDemo {

    //  归并排序
    public static void margeSort(int[] array) {
        // [0，array.length)
        margeSortHelper(array, 0, array.length);
    }

    private static void margeSortHelper(int[] array, int left, int right) {
        if (right - left <= 1) {
            return;
        }
        int mid = (left + right)/2;
        margeSortHelper(array, left, mid);
        margeSortHelper(array, mid, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
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

    // 快速排序
    public static void quickSort(int[] array) {
        // [0, array.length - 1]
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

    // 希尔排序
    public static void shellSort(int[] array) {
        int gap = array.length/2;
        while (gap >= 1) {
            shellSortHelper(array, gap);
            gap = gap/2;
        }
    }
    private static void shellSortHelper(int[] array, int gap) {
        for (int bound = gap; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound - gap;
            for ( ; cur >= 0; cur -= gap) {
                if (array[cur] > tmp) {
                    array[cur + gap] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + gap] = tmp;
        }
    }

    // 冒泡排序
    public static void bobbleSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = array.length - 1; cur > bound; cur--) {
                if (array[cur] < array[cur - 1]) {
                    swap(array, cur, cur - 1);
                }
            }
        }
    }
    public static void bobbleSort1(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = 0; cur < array.length - bound - 1; cur++) {
                if (array[cur] > array[cur + 1]) {
                    swap(array, cur, cur + 1);
                }
            }
        }
    }

    // 选择排序
    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = bound; cur < array.length; cur++) {
                if (array[bound] > array[cur]) {
                    swap(array,bound, cur);
                }
            }
        }
    }

    // 插入排序
    public static void insertSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound - 1;
            for (; cur >= 0; cur--) {
                if (array[cur] > tmp) {
                    array[cur + 1] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
    }

    // 堆排序
    public static void HeapSort(int[] array) {
        createHeap(array);
        int heapSize = array.length;
        while (heapSize > 0) {
            swap(array, 0, heapSize - 1);
            heapSize--;
            upLoad(array, heapSize, 0);
        }
    }

    // 创建堆
    public static void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1)/2; i >= 0; i--) {
            upLoad(array, array.length, i);
        }
    }

    private static void upLoad(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size && array[child] < array[child + 1]) {
                child = child + 1;
            }
            if (array[child] > array[parent]) {
                swap(array, child, parent);
            }
            parent = child;
            child = 2*parent + 1;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {2,3,4,5,7,1,9,0,6};
//        createHeap(array);
//        System.out.println(Arrays.toString(array));
//        HeapSort(array);
//        System.out.println(Arrays.toString(array));
        // insertSort(array);
        // selectSort(array);
        // bobbleSort(array);
        // bobbleSort1(array);
        // shellSort(array);
        // quickSort(array);
        margeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
