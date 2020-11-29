import java.util.Arrays;

public class Sort {
    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = bound + 1; cur < array.length ; cur++) {
                if (array[cur] < array[bound]) {
                    swap(array, cur, bound);
                }
            }
        }
    }

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

    private static void swap(int[] array, int cur, int bound) {
        int tmp = array[cur];
        array[cur] = array[bound];
        array[bound] = tmp;
    }

    public static void bubbleSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = 0; cur < array.length - 1 - bound; cur++) {
                if (array[cur] > array[cur + 1]) {
                    swap(array, cur, cur + 1);
                }
            }
        }
    }
    public static void shellSort(int[] array) {
        int gap = array.length/2;
        while (gap >= 1) {
            shellSortHelper(array, gap);
            gap /= 2;
        }
    }

    private static void shellSortHelper(int[] array, int gap) {
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
        int len = array.length - 1;
        while (len >= 0) {
            swap(array, 0, len);
            len--;
            shiftDown(array, len, 0);
        }
    }

    private static void createHeap(int[] array) {
        for (int i = ((array.length - 1) - 1)/2; i >= 0 ; i--) {
            shiftDown(array, array.length, i);
        }
    }

    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent  + 1;
        while (child < size) {
            if (child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if (array[parent] < array[child]) {
                swap(array, child, parent);
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    public static void main(String[] args) {
        int[] array = {7,5,6,8,9,1,2,3,4,0};
        //selectSort(array);
        //insertSort(array);
        //bubbleSort(array);
        //shellSort(array);
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
