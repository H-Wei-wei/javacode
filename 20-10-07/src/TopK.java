
/**
 * TopK问题
 * 建大堆，求前 K 小的值
 * 建小堆，求前 K 大的值
 */

import java.util.Arrays;

public class TopK {

    public static int[] func(int[] array, int K) {
        if (K <= 0 || K > array.length) {
            return array;
        }
        // 建堆
        int[] result = new int[K];
        for (int i = 0; i < K; i++) {
            result[i] = array[i];
        }
        createHeap(result);
        //System.out.println(Arrays.toString(result));
        for (int i = K; i < array.length; i++) {
            if (array[i] < result[0]) {
                result[0] = array[i];
                createHeap(result);
            }
        }
        return result;
    }

    private static void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1)/2; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }
    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2*parent + 1;
        while (child < size) {
            if (child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if (array[child] > array[parent]) {
                swap(array, child, parent);
            }
            parent = child;
            child = 2*parent + 1;
        }
    }
    private static void swap(int[] array, int bound, int cur) {
        int tmp = array[bound];
        array[bound] = array[cur];
        array[cur] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {3,5,67,2,5,65,47,353,8,9};
        System.out.println(Arrays.toString(func(array, 3)));
    }
}
