import java.util.LinkedList;
import java.util.Queue;

/**
 * 优先队列
 */

public class MyPriorityQueue {

    private int[] array = new int[100]; // 不考虑扩容问题
    private int size = 0; // [0,size) 为数组下标

    private void offer(int x) {
        array[size] = x;
        size++;
        // 把 x 进行向上调整
        shiftUp(array, size, 0);

    }

    private void shiftUp(int[] array, int size,int index) {
        int child = 
    }

    // 向下调整
    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = parent*2 + 1;
        while (child < size) {
            if(child + 1 < size && array[child+1] > array[child]) {
                child = child + 1;
            }
            if(array[child] > array[parent]) {
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

    }


}
