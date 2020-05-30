import java.util.Arrays;

public class Sort {
    // 插入排序 --- 稳定排序
    public static void insertSort(int[] array) {
        for (int bound = 1; bound < array.length; bound++) {
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

    // 希尔（shell）排序
    public static void shellSort(int[] array) {
        int gap = array.length / 2;
        while (gap >= 1) {
            insertSortGap(array, gap);
            gap = gap / 2;
        }
    }
    private static void insertSortGap(int[] array, int gap) {
        for (int bound = gap; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound - gap;
            for (; cur >= 0; cur = cur - gap) {
                if (array[cur] > tmp) {
                    array[cur + gap] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + gap] = tmp;
        }
    }

    // 选择排序
    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = bound + 1; cur < array.length; cur++) {
                if (array[cur] < array[bound]) {
                    swap(array, cur, bound);
                }
            }
        }
    }
    private static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    // 冒泡排序
    public static void bubbleSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = 0; cur < array.length - 1 - bound; cur++) {
                // cur + 1 位置存放的是最大值
                if (array[cur + 1] < array[cur]) {
                    swap(array, cur, cur + 1);
                }
            }
            /*for (int cur = array.length - 1; cur > bound; cur--) {
                if (array[cur] < array[cur - 1]) {
                    swap(array, cur, cur - 1);
                }
            }*/
        }
    }

    // 堆排序
    public static void heapSort(int[] array) {
        createHeap(array);
        int heapSize = array.length;
        while (heapSize > 0) {
            swap(array, 0, heapSize - 1);
            heapSize--;
            shiftDown(array, heapSize, 0);
        }
    }
    private static void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i --){
            shiftDown(array, array.length, i);
        }
    }
    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if (array[parent] < array[child]) {
                swap(array, parent, child);
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    // 快速排序
    public static void quickSort(int[] array) {
        // [ , ]
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
        int baseValues = array[right];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && array[i] <= baseValues) {
                i++;
            }
            while (i < j && array[j] >= baseValues) {
                j--;
            }
            swap(array, i, j);
        }
        swap(array, right, i);
        return i;
    }

    // 归并排序
    public static void mergeSort(int[] array) {
        // [ , );
        mergeSortHelp(array, 0, array.length);
    }

    private static void mergeSortHelp(int[] array, int left, int right) {
        if (right - left <= 1) {
            return;
        }
        int mid = (left + right) /2;
        mergeSortHelp(array, left, mid);
        mergeSortHelp(array, mid, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int cur1 = left;
        int cur2 = mid;

        int[] output = new int[right - left];
        int outputSize = 0;

        while (cur1 < mid && cur2 < right) {
            if (array[cur1] <= array[cur2]) {
                output[outputSize] = array[cur1];
                outputSize++;
                cur1++;
            }else  {
                output[outputSize] = array[cur2];
                outputSize++;
                cur2++;
            }
        }
        while (cur1 < mid) {
            output[outputSize] = array[cur1];
            outputSize++;
            cur1++;
        }
        while (cur2 < right) {
            output[outputSize] = array[cur2];
            outputSize++;
            cur2++;
        }

        for (int i =0; i < outputSize; i++) {
            array[left + i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {4,7,2,1,5,8,9,3,10};
        //insertSort(array);
        //shellSort(array);
        //selectSort(array);
        bubbleSort(array);
        //heapSort(array);
        //quickSort(array);
        //mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
