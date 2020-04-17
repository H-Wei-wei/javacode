

/**
 * 用顺序表表示队列
 */

public class MyQueue2 {
    private int[] array = new int[100];
    // [head,tail),初始情况下队列为空
    private int head = 0;  // 队首
    private int tail = 0;  // 队尾
    private int size = 0;  // 队列元素个数

    // 入队
    private  boolean offer(int value) {
        // 当元素个数与数组长度相等时，代表数组满了
        if(size == array.length) {
            return false;
        }
        array[tail] = value;
        tail++;
        // tail 的取值为 [0,array.length-1)
/*        if(tail >= array.length) {
            tail = 0;
        }
*/
        tail = tail % array.length;
        size++;
        return true;
    }

    // 出队
    private Integer poll() {
        // 队列为空，出队列失败
        if(size == 0) {
            return null;
        }
        // 返回 head 位置元素，然后删掉它
        int ret = array[head];
        head++;
        size--;
        if(head == array.length) {
            head = 0;
        }
        return ret;
    }

    // 取队首元素
    private Integer peek() {
        if(size == 0) {
            return null;
        }
        return array[head];
    }

    public static void main(String[] args) {
        MyQueue2 myQueue2 = new MyQueue2();
        myQueue2.offer(1);
        myQueue2.offer(2);
        myQueue2.offer(3);
        myQueue2.offer(4);

        System.out.println(myQueue2.peek());

        while (true) {
            Integer ret = myQueue2.poll();
            if (ret == null) {
                break;
            }
            System.out.println(ret);
        }
    }
}
