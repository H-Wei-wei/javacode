import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * TopK问题
 */

public class HeapTopK {
    private int[] KSmallNum(int[] array,int k) {
        if(k <= 0 || k > array.length) {
            return array;
        }
       //PriorityQueue<Integer> queue = new PriorityQueue<>();
        int[] ret = new int[k];
        // 先将 array 前 K 个元素加到 ret中
        for(int i = 0; i < k; i++ ) {
            ret[i] = array[i];
        }
        // 建小堆
        for(int i = (k-1-1)/2; i >= 0; i--) {
            shiftDown(ret, k, i);
        }

        // 循环拿堆顶元素与array中的其他元素进行比较
        while (k < array.length) {
            if(ret[0] < array[k]) {
                ret[0] = array[k];
                shiftDown(ret,ret.length,0);
            }
            k = k+1;
        }
        return ret;
    }

    private void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2*parent + 1;
        while(child < size) {
            if(child+1 < size && array[child+1] < array[child]) {
                child = child + 1;
            }
            if(array[child] < array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            }else {
                break;
            }
            parent = child;
            child = 2*parent + 1;
        }
    }

    public static void main(String[] args) {
        HeapTopK heapTopK = new HeapTopK();
        int[] array = {9,6,5,2,1,4,7,8};
        int[] ret = heapTopK.KSmallNum(array, 4);
        // 打印出来的结果是无序的
        System.out.println(Arrays.toString(ret));
        // 想要得到是第几大的值，就得重新排序
    }
}
