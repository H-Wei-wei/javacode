/**
 * 堆
 */

public class Heap {
    // 向下调整
    // index 表示从哪个下标开始调整
    public static void shiftDown(int[] array,int size,int index) {
        // 先找到父节点的下标
        int parent = array[index];
        // 再找到左子树下标
        int child = 2 * parent - 1;

        while(child < size) {
            // 判断右子树
            if (child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            // 此时 child 指向左右子树中的最大值
            // 判断 -- 左右子树最大值与根节点对比
            if(array[child] > array[parent] ){
                int tmp = array[child + 1];
                array[child + 1] = array[parent];
                array[parent] = tmp;
            }else {
                // 当根节点大于左右子树最大值，满足大堆，则跳出循环
                break;
            }
            // 更新父节点和左子树下标
            parent = child;
            child = 2 * parent - 1;
        }
    }
}
