import java.util.Arrays;

public class Sort {
    public static void insertSort (int[] array) {
        for (int bound = 1; bound < array.length; bound++) {
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

    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = bound + 1; cur < array.length; cur++) {
                if (array[bound] > array[cur]) {
                    swap(array, bound, cur);
                }
            }
        }
    }
    private static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void bubbleSort1(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = 0; cur < array.length - 1 -bound; cur++) {
                if (array[cur] > array[cur + 1]) {
                    swap(array, cur, cur + 1);
                }
            }
        }
    }
    public static void bubbleSort2(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = array.length - 1; cur > bound; cur--) {
                if (array[cur] < array[cur - 1]) {
                    swap(array, cur, cur - 1);
                }
            }
        }
    }

    public static void shellSort(int[] array) {
        int gap = (array.length) / 2;
        while (gap >= 1) {
            insertSortGap(array, gap);
            gap = gap / 2;
        }
    }
    private static void insertSortGap(int[] array, int gap) {
        for (int bound = gap; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound - gap;
            for (; cur >= 0; cur -= gap) {
                if (array[cur] > tmp) {
                    array[cur + gap] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + gap] = tmp;
        }
    }

    public static void heapSort(int[] array) {
        createHeap(array);
        int heapSize = array.length;
        while (heapSize > 0) {
            swap(array, 0, heapSize - 1);
            heapSize -= 1;
            shiftDown(array, heapSize, 0);   //向下调整
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
            }else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    private static void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1)/2; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 6, 7, 5, 2, 8, 0,1, 3};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
