import java.util.Arrays;

/**
 * 针对整个集合，建立一个大小为 N 的大堆，循环取 K 次堆顶元素；
 */
public class HeapTopK2 {
    // 建堆
    public void createHeap(int[] array, int size) {
        for(int i = (size-1-1)/2; i >= 0; i--) {
            shiftDown(array, size, i);
        }
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
        HeapTopK2 heapTopK2 = new HeapTopK2();
        int[] array = {9,6,5,2,1,4,7,8};
        heapTopK2.createHeap(array,array.length);
        System.out.println(Arrays.toString(array));
    }
}
