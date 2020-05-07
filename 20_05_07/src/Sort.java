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
    public static void swap(int[] array, int cur, int bound) {
        int tmp = array[cur];
        array[cur] = array[bound];
        array[bound] = tmp;
    }

    // 堆排序
    public static void HeapSort(int[] array) {
        // 创建一个大堆
        creatHeap(array);
        int HeapSortSize = array.length;
        while(HeapSortSize >= 0) {
            // 取堆顶元素与最后一个元素交换位置
            swap(array,0,array.length-1);
            shifDown(array,HeapSortSize,0);
            HeapSortSize --;
        }
    }

    private static void shifDown(int[] array, int heapSortSize, int i) {
    }

    private static void creatHeap(int[] array) {
        for(int i = (array.length -1 -1)/2; i >= 0; i--) {
            
        }
    }

    public static void main(String[] args) {
        int[] array ={1,3,6,4,5,8,9,7,2};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}
