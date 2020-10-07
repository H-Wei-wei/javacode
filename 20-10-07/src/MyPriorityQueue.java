import java.util.Arrays;

public class MyPriorityQueue {

    public int[] array = new int[100];
    public int size = 0;

    //入队列
    public void offer(int x) {
        array[size] = x;
        size++;
        shiftUp(array, size, size - 1);
    }
    private void shiftUp (int[] array, int size, int index) {
        int child = index;
        int parent = (child - 1)/2;
        while (child > 0) {
            if (array[child] > array[parent]) {
                swap(array, child, parent);
            }else {
                break;
            }
            child = parent;
            parent = (child - 1)/2;
        }
    }

    public int poll() {
        if (array.length == 0) {
            return -1;
        }
        int ret = array[0];
        array[0] = array[size - 1];
        size--;
        shiftDown(array, size, 0);
        return ret;
    }

    private void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2*parent + 1;
        while (child < size) {
            if (child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if (array[child] > array[parent]) {
                swap(array, child, parent);
            }else {
                break;
            }
            parent = child;
            child = 2*parent + 1;
        }
    }
    private  void swap(int[] array, int bound, int cur) {
        int tmp = array[bound];
        array[bound] = array[cur];
        array[cur] = tmp;
    }

    public int peak() {
        if (size == 0) {
            return -1;
        }
        return array[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public static void main(String[] args) {
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue();
        myPriorityQueue.offer(1);
        myPriorityQueue.offer(2);
        myPriorityQueue.offer(3);
        myPriorityQueue.offer(4);
        myPriorityQueue.offer(5);
        System.out.println(Arrays.toString(myPriorityQueue.array));
        while (!myPriorityQueue.isEmpty()) {
            System.out.println(myPriorityQueue.poll());
        }
    }
}
