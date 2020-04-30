import java.util.Arrays;

/**
 * 堆
 */

public class Heap {
    // 向下调整
    // index 表示从哪个下标开始调整
    public static void shiftDown(int[] array,int size,int index) {
        // 先找到父节点的下标
        int parent = index;
        // 再找到左子树下标
        int child = 2 * parent + 1;

        while(child < size) {
            // 判断右子树
            if (child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            // 此时 child 指向左右子树中的最大值
            // 判断 -- 左右子树最大值与根节点对比
            if(array[child] > array[parent] ){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            }else {
                // 当根节点大于左右子树最大值，满足大堆，则跳出循环
                break;
            }
            // 更新父节点和左子树下标
            parent = child;
            child = 2 * parent + 1;
        }
    }
    private static void shiftUp(int[] array,int size, int index) {
        int child = index;
        int parent = (index-1)/2;
        while(parent < size) {
            if(array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            }else {
                break;
            }
            child = parent;
            parent = (index-1)/2;
        }
    }

    // 向下方式建堆 --- 从后往前遍历
    private static void createHeap(int[] array,int size) {
        // size-1 为最后一个元素的下标，（size-1 -1)/2 为父节点的下标
        for(int i = (size -1 -1)/2; i >= 0; i--) {
            shiftDown(array,size,i);
        }
    }
    // 向上方式建堆 --- 从前往后遍历
    private static void createHeap2(int[] array ,int size) {
        for (int i = 1; i < size; i++ ) {
            shiftUp(array,size,i);
        }
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        createHeap2(array,array.length);
        System.out.println(Arrays.toString(array));
    }
}
