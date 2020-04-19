import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 用队列实现栈
 */
public class MyStack {

    Queue<Integer> A = new LinkedList<>();
    Queue<Integer> B = new LinkedList<>();


    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        // 把A中的元素入栈
        A.offer(x);

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // 栈为空时
        if(empty()) {
            return 0;
        }
        while(A.size() > 1) {
            B.offer(A.poll());
        }
        // 队列中就剩一个元素，
        int top = A.poll();
        // 交换A，B队列
        swap();
        // 返回出栈顶元素
        return top;

    }

    public void swap() {
        Queue<Integer> tmp = A;
        A = B;
        B = tmp;
    }

    /** Get the top element. */
    public int top() {
        if(empty()) {
            return 0;
        }
        while(A.size() > 1) {
            B.offer(A.poll());
        }
        int top = A.poll();
        B.offer(top);
        swap();
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}
