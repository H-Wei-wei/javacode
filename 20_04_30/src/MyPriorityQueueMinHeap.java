/**
 * 优先队列------ 小堆
 */

public class MyPriorityQueueMinHeap {

    private int[] array = new int[100]; // 不考虑扩容问题
    private int size = 0; // [0,size) 为数组下标

     // 入队列 ----  数组尾插向上调整
    private void offer(int x) {
        // 把 x 放到数组的末尾
        array[size] = x;
        size++;
        // 把 x 进行向上调整
        // 第一个参数是数组
        // 第二个参数是数组大小
        // 第三个参数是从哪个位置开始向上调整
        shiftUp(array, size, size-1);

    }

    // 出队列 ---- 数组头删向下调整
    private Integer poll() {
        if(size == 0) {
            return null;
        }
        int ret = array[0];
        // 将最后一个元素的值赋值给第下标为0的元素
        array[0] = array[size-1];
        size--;
        // 从 0 号下标位置向下调整
        shiftDown(array,size,0);
        return ret;
    }

    // 向上调整
    private void shiftUp(int[] array, int size,int index) {
        int child = index;
        int parent = (child - 1)/2;
        // 当 child 等于 0 时，就是指向根节点
        while(child > 0) {
            // 比较当前 child 和 parent 之间的大小关系，看是否符合小堆要求
            if(array[child] < array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            }else {
                break;
            }
            child = parent;
            parent = (child - 1)/2;
        }
    }

    // 向下调整
    private void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = parent*2 + 1;
        while (child < size) {
            if(child + 1 < size && array[child+1] < array[child]) {
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

    // 取队首元素
    private Integer peak() {
        if(size == 0) {
            return null;
        }
        return array[0];
    }

    // 判空
    private boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        MyPriorityQueueMinHeap queue = new MyPriorityQueueMinHeap();
        queue.offer(2);
        queue.offer(4);
        queue.offer(8);
        queue.offer(3);
        queue.offer(1);
        queue.offer(9);

        // 循环出队列
        while(!queue.isEmpty()) {
            System.out.print(queue.poll()+" ");
        }
    }


}
