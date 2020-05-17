import java.util.Arrays;

public class Sort2 {
    // 插入排序
    public void insertSort(int[] array) {
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

    // 希尔排序
    public void shellSort(int[] array) {
        // 希尔数组
        int gap = array.length / 2;
        while (gap >= 1) {
            shellSortGap(array,gap);
            gap = gap / 2;
        }
    }
    private void shellSortGap(int[] array, int gap) {
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
    public void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = bound + 1; cur < array.length; cur++) {
                if (array[cur] < array[bound]) {
                    swap(array,cur,bound);
                }
            }
        }
    }

    public void swap(int[] array, int a ,int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    // 冒泡排序
    public void bubbleSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = array.length-1; cur > bound; cur--) {
                if (array[cur - 1] > array[cur]) {
                    swap(array,cur - 1, cur);
                }
            }
        }
    }
    public void bubbleSort2(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = 0; cur < array.length - 1 - bound; cur++) {
                if (array[cur + 1] < array[cur]) {
                    swap(array,cur + 1, cur);
                }
            }
        }
    }

    // 堆排序
    public void heapSort(int[] array) {
        // 创建堆
        createHeap(array);
        int heapSize = array.length;
        while (heapSize > 0) {
            swap(array, 0, heapSize - 1);
            heapSize--;
            shiftDown(array, heapSize, 0);
        }

    }
    private void createHeap(int[] array) {
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            shiftDown(array,array.length,i);
        }
    }
    private void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2*parent + 1;
        while (child < size) {
            if (child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            // child 指向子节点中，值较大的元素
            if (array[child] > array[parent]) {
                swap(array, child, parent);
            }else {
                break;
            }
            parent = child;
            child = 2*parent + 1;
        }
    }

    // 快速排序
    public void quickSort(int[] array) {
        // 辅助递归方法 [0, array.length - 1]
        quickSortHelper(array, 0, array.length-1);
    }
    private void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            // 当数组中只有一个数时，不需要排序
            return;
        }
        // 基准值位置
        int index = patition(array, left,right);
        quickSortHelper(array, left, index - 1);
        quickSortHelper(array, index + 1, right);
    }
    private int patition(int[] array, int left, int right) {
        int baseValue = array[right];
        int i = left;
        int j = right;
        while (i < j) {
            // 先从左往右找，找比基准值大的元素
            while (i < j && array[i] <= baseValue) {
                i++;
            }
            // 再从右往左找，找小于基准值的元素
            while (i < j && array[j] >= baseValue) {
                j--;
            }
            swap(array, i, j);
        }
        // i == j, 这个元素和基准值交换位置
        swap(array,i,right);
        return i;
    }

    // 归并排序
    public void mergeSort(int[] array) {
        // [0, array.length)
        mergeSortHelper(array, 0, array.length);
    }
    private void mergeSortHelper(int[] array, int left, int right) {
        if (right - left <= 1) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSortHelper(array, left, mid);
        mergeSortHelper(array, mid, right);
        merge(array, left, mid, right);
    }
    private void merge(int[] array, int left, int mid, int right) {
        int cur1 = left;
        int cur2 = mid;

        int[] output = new int[right - left];
        int outputSize = 0;

        while (cur1 < mid && cur2 < right) {
            if (array[cur1] <= array[cur2]) {
                output[outputSize] = array[cur1];
                outputSize++;
                cur1++;
            }else if (array[cur2] <= array[cur1]) {
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

        for (int i = 0; i < output.length; i++) {
            array[left + i] = output[i];
        }
    }

    public static void main(String[] args) {
        Sort2 sort2 = new Sort2();
        int[] array = {7,8,5,6,9,2,4,3,1};
        //sort2.insertSort(array);
        //sort2.shellSort(array);
        //sort2.selectSort(array);
        //sort2.bubbleSort2(array);
        //sort2.heapSort(array);
        //sort2.quickSort(array);
        sort2.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
