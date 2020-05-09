import java.util.Arrays;

public class Sort {
    // 选择排序(升序为例)
    public static void selectSort(int[] array) {
        for(int bound = 0; bound < array.length; bound++) {
            for(int cur = bound +1; cur < array.length; cur++) {
                if(array[cur] < array[bound]) {
                    // 交互位置
                    swap(array,cur,bound);
                }
            }
        }
    }
    public static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    // 堆排序
    public static void heapSort(int[] array) {
        // 创建一个大堆
        createHeap(array);
        int heapSize = array.length;
        while (heapSize > 0){
            // 交换堆顶元素与最后一个元素位置
            swap(array,0,heapSize-1);
            // 去掉最后一个元素
            heapSize --;
            // 对根节点进行向下调整
            shiftDown(array,heapSize,0);
        }
    }

    private static void createHeap(int[] array) {
        // 从最后一个非叶子节点出发，从后往前遍历，依次进行向下调整
        for(int i = (array.length - 1 - 1)/2; i >= 0; i--) {
            shiftDown(array,array.length,i);
        }
    }

    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2*parent + 1;
        while(child < size) {
            if(child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            // child 指向当前节点的左右子树中的较大值
            if(array[child] > array[parent]) {
                swap(array,child,parent);
            }else {
                break;
            }
            parent = child;
            child = 2*parent + 1;
        }
    }

    // 冒泡排序
    /*public static void bubbleSort(int[] array) {
        for(int bound = 0; bound < array.length; bound++) {
            // 看相邻元素是否满足升序要求
            for(int cur = array.length - 1; cur > bound; cur--) {
                if(array[cur - 1] > array[cur] ) {
                    swap(array, cur - 1,cur);
                }
            }
        }
    }*/
    public static void bubbleSort(int[] array) {
        for(int bound = 0; bound < array.length; bound++) {
            // 看相邻元素是否满足升序要求
            for(int cur = 0; cur < array.length - bound -1; cur++) {
                if(array[cur + 1] < array[cur] ) {
                    swap(array,cur + 1,cur);
                }
            }
        }
    }

    // 快速排序
    public static void quickSort(int[] array) {
        //创建一个辅助方法，来进行递归
        quickSortHelper(array,0,array.length-1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if(left >= right) {
            // 说明区间中只有一个元素或是0个元素，就不需要进行排序
            return;
        }
        // 整理之后，基准值所在位置
        int index = partition(array,left,right);
        // 在[left,index-1]递归寻找基准值
        quickSortHelper(array,left,index-1);
        // 在[index+1，right]递归寻找基准值
        quickSortHelper(array,index+1,right);
    }

    private static int partition(int[] array, int left, int right) {
        int baseValue = array[right];
        int i = left;
        int j = right;
        while(i < j){
            // 1.从左往右找一个比基准值大的值
            while(i < j && array[i] <= baseValue) {
                 i++;
            }
            // 此时 i 指向大于基准值的元素
            // 2.找一个比基准值小的值
            while(i < j && array[j] >= baseValue) {
                j--;
            }
            // 此时 j 指向小于基准值的元素
            // 3.交换 i 和 j 位置元素
            if(i < j) {
                swap(array, i,j);
            }
        }
        // i 和 j 重合
        // 交换 i 位置元素和 基准值
        swap(array, i, right);
        return i;
    }

    public static void main(String[] args) {
        int[] array ={1,3,6,4,5,8,9,7,2};
        selectSort(array);
        //heapSort(array);
        //bubbleSort(array);
        //quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
