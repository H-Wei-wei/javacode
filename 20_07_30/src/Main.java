import java.util.Arrays;

public class Main {
    public static void heapSort (int[] array) {
        //建堆
        createHeap(array);
        int heapSize = array.length;
        while (heapSize > 0) {
            swap(array, 0, heapSize - 1);
            heapSize--;
            shiftUp(array, heapSize, 0);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static void createHeap(int[] array) {
        for (int i = (array.length - 1 -1)/2; i >= 0; i--) {
            shiftUp(array, array.length, i);
        }
    }

    private static void shiftUp(int[] array, int size, int index) {
        int parent = index;
        int child = 2*parent + 1;
        while (child < size) {
            if (child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            // child 始终指向子节点中的最大数
            if (array[parent] < array[child]) {
                swap(array, parent, child);
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 6, 5, 8, 1, 2, 3, 0};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
