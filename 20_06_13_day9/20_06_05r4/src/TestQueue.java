import java.util.Stack;

public class TestQueue {
    Stack<Integer> stack1 = new Stack<Integer>();   // 用来入队列
    Stack<Integer> stack2 = new Stack<Integer>();   // 用来出队列

    public void push(int node) {
        //当 static2 中有数据时，将所有数据倒腾到 static1 中
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        // 入队列
       stack1.push(node);
    }

    public Integer pop() {
        // 当两栈为空时，返回null
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return null;
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public boolean Empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        TestQueue queue = new TestQueue();
        queue.push(5);
        queue.push(4);
        queue.push(3);
        queue.push(2);
        queue.push(1);

        while (!queue.stack2.isEmpty()) {
            System.out.print(queue.pop() + " ");
        }
    }
}
