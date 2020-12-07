import java.util.Arrays;
import java.util.Scanner;

public class Sort {
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
    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = bound + 1; cur < array.length ; cur++) {
                if (array[cur] < array[bound]) {
                    swap(array, cur, bound);
                }
            }
        }
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

    private static void swap(int[] array, int cur, int bound) {
        int tmp = array[cur];
        array[cur] = array[bound];
        array[bound] = tmp;
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

    public static void heapSort(int[] array) {
        createHeap(array);
        int size = array.length - 1;
        while (size >= 0) {
            swap(array, 0, size);
            shiftDown(array, size, 0);
            size--;
        }
    }

    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size && array[child] < array[child + 1]) {
                child = child + 1;
            }
            if (array[parent] < array[child]) {
                swap(array, parent, child);
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    private static void createHeap(int[] array) {
        for (int i = ((array.length - 1) - 1)/2; i >= 0 ; i--) {
            shiftDown(array, array.length, i);
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
        int[] arr = new int[right - left];
        int index = 0;
        while (cur1 < mid && cur2 < right) {
            if (array[cur1] <= array[cur2]) {
                arr[index] = array[cur1];
                index++;
                cur1++;
            }else {
                arr[index] = array[cur2];
                index++;
                cur2++;
            }
        }
        while (cur1 < mid) {
            arr[index] = array[cur1];
            index++;
            cur1++;
        }
        while (cur2 < right) {
            arr[index] = array[cur2];
            index++;
            cur2++;
        }
        for (int i = 0; i < index; i++) {
            array[i + left] = arr[i];
        }
    }

    public static int binarySearch(int[] array, int value) {
        // [0, array.length)
        int left = 0;
        int right = array.length;
        int count= 0;
        while (right - left >= 1) {
            int mid = (left + right)/2;
            count++;
            if (array[mid] < value) {
                left = mid + 1;
            }else if (array[mid] > value) {
                right = mid;
            }else {
                System.out.println(count);
                return mid;
            }
        }
        System.out.println(count);
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        //insertSort(array);
        //selectSort(array);
        //bubbleSort(array);
        //shellSort(array);
        //heapSort(array);
        //quickSort(array);
        //mergeSort(array);
        System.out.println(binarySearch(array, 11));
       // System.out.println(Arrays.toString(array));
    }
}
