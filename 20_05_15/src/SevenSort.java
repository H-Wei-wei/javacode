import java.util.Arrays;

public class SevenSort {
    // 插入排序
    public static void insertSort(int[] array) {
        for(int bound = 1; bound < array.length; bound ++) {
            int tmp = array[bound];
            int cur = bound - 1;
            for(; cur >= 0; cur--) {
                if(array[cur] > tmp) {
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
        int gap = array.length / 2;
        while (gap >= 1) {
            insertSortGap(array,gap);
            gap = gap / 2;
        }
    }
    private static void insertSortGap(int[] array, int gap) {
        for(int bound = gap; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound - gap;
            for(; cur >= 0 ; cur -= gap) {
                if(array[cur] > tmp) {
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
        for(int bound = 0; bound < array.length; bound++) {
            for(int cur = bound + 1; cur < array.length;cur++) {
                if(array[cur] < array[bound]) {
                    swap(array,cur,bound);
                }
            }
        }
    }
    public static void swap(int[] array, int a,int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    // 冒泡排序
    public static void bubbleSort(int[] array) {
        for(int bound = 0; bound < array.length; bound++) {
            for(int cur = array.length - 1; cur > bound; cur--) {
                if(array[cur - 1] > array[cur]) {
                    swap(array,cur - 1,cur);
                }
            }
        }
    }

    // 堆排序
    public static void heapSort(int[] array) {
        createHeap(array);
        int heapSize = array.length;
        while (heapSize > 0) {
            swap(array,0,heapSize - 1);
            heapSize--;
            shiftDown(array,heapSize,0);
        }
    }

    private static void createHeap(int[] array) {
        for(int i = (array.length - 1 - 1) / 2; i >=0; i--) {
            shiftDown(array,array.length,i);
        }
    }

    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2*parent + 1;
        while (child < size) {
            if(child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if(array[child] > array[parent]) {
                swap(array,child,parent);
            }
            parent = child;
            child = 2*parent + 1;
        }
    }

    // 快速排序
    public static void  quickSort(int[] array) {
        quickSortHelper(array,0,array.length-1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        // [ left, right]
        if(left >= right) {
            return;
        }
        int index = partition(array,left,right);
        quickSortHelper(array,left,index - 1);
        quickSortHelper(array,index + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        // 基准值
        int baseValue = array[right];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && array[i] <= baseValue) {
                i++;
            }
            // 此时 i 指向大于基准值的元素位置
            while (i < j && array[j] >= baseValue) {
                j--;
            }
            // 此时 j 指向小于基准值的元素位置
            // 交换两元素
            swap(array,i,j);
        }
        // i 和 j 重合，将此元素与基准值交换位置
        swap(array,i,right);
        return i;
    }

    // 归并排序
    public static void mergeSort(int[] array) {
        // [ 0, size) 区间为左闭右开
        mergeSortHelper(array,0,array.length);
    }

    private static void mergeSortHelper(int[] array,int left, int right) {
        if(right - left <= 1) {
            return;
        }
        int mid = (left + right) / 2;
        // [ left , mid)
        mergeSortHelper(array,left,mid);
        // [ mid , right)
        mergeSortHelper(array,mid,right);
        // 合并两数组元素
        merge(array,left,mid,right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int cur1 = left;
        int cur2 = mid;

        // 临时空间的大小应该可容纳合并后两数组大小
        int[] output = new int[right - left];
        int outputIndex = 0;

        while (cur1 < mid && cur2 < right) {
            if(array[cur1] <= array[cur2]) {
                output[outputIndex] = array[cur1];
                cur1++;
                outputIndex++;
            }else {
                output[outputIndex] = array[cur2];
                cur2++;
                outputIndex++;
            }
        }
        // 当 cur1 中还有剩余元素时
        while (cur1 < mid) {
            output[outputIndex] = array[cur1];
            outputIndex++;
            cur1++;
        }
        // 当 cur2 中还有剩余元素时
        while (cur2 < right) {
            output[outputIndex] = array[cur2];
            outputIndex++;
            cur2++;
        }
        // 将临时空间中的数据拷贝到原数组中
        for(int i = 0; i < outputIndex; i++) {
            array[left + i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {1,5,4,3,8,9,6,2,7};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
