import java.util.LinkedList;
import java.util.Queue;

public class MyStackBy2Queue {
    private Queue<Integer> A = new LinkedList<>();
    private Queue<Integer> B = new LinkedList<>();

    // 入队列
    public void push(int x) {
        A.offer(x);
    }

    // 出队列
    public Integer pop() {
        if (empty()) {
            return null;
        }
        while (A.size() > 1) {
            // 将A中的元素放入B中
            Integer cur = A.poll();
            B.offer(cur);
        }
        // 当A中只有一个元素的时候，
        int ret = A.poll();
        // 交换 A B两栈
        swap();
        return ret;
    }

    public void swap() {
        Queue<Integer> tmp = A;
        A = B;
        B = tmp;
    }

    // 取队首元素
    public Integer peak() {
        if (empty()) {
            return null;
        }
        while (A.size() > 1) {
            // 将A中的元素放入B中
            Integer cur = A.poll();
            B.offer(cur);
        }
        // 当A中只有一个元素的时候，
        int ret = A.poll();
        B.offer(ret);
        // 交换 A B两栈
        swap();
        return ret;
    }

    //判空
    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }

    public static void main(String[] args) {
        MyStackBy2Queue stack = new MyStackBy2Queue();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.peak());
        while (!stack.A.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
