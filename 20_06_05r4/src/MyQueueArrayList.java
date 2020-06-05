/**
 * 顺序表实现循环队列
 */
public class MyQueueArrayList {
    private int[] array = new int[5];
    private int head = 0;
    private int tail = 0;
    private int size = 0; // 元素个数

    // 入队列
    private void offer(int val) {
        if (size == array.length) {
            // 队列满了无法插入
            return;
        }
        array[tail] = val;
        tail++;
        if (tail >= array.length) {
            tail = 0;
        }
        size++;
    }
    // 出队列
    private Integer poll() {
        if (size == 0) {
            return null;
        }
        int ret = array[head];
        head++;
        if (head >= array.length) {
            head = 0;
        }
        size--;
        return ret;
    }
    // 取队首元素
    private Integer peak() {
        if (size == 0) {
            return null;
        }
        return array[head];
    }

    public static void main(String[] args) {
        MyQueueArrayList queue = new MyQueueArrayList();
        queue.offer(5);
        queue.offer(4);
        queue.offer(3);
        queue.offer(2);
        queue.offer(1);
        System.out.println(queue.peak());
        while (queue.size != 0) {
            System.out.print(queue.poll() + " ");
        }
    }
}
