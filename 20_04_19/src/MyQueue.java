import java.util.Stack;

/**
 * 用栈实现队列
 */

public class MyQueue {

    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // A负责入队列，B负责出队列
        if (!B.empty()){
            A.push(B.pop());
        }
        A.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(empty()) {
            return 0;
        }
        while(!A.empty()) {
            B.push(A.pop());
        }
        return B.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (empty()) {
            return 0;
        }
        while(!A.empty()) {
            B.push(A.pop());
        }
        return B.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return A.empty() && B.empty();
    }

}
