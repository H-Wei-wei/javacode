import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueue {
//    // 两栈实现队列
//    public Stack<Integer> stack1 = new Stack<>();
//    public Stack<Integer> stack2 = new Stack<>();
//    public void offer(int x) {
//        while (!stack2.isEmpty()) {
//            stack1.push(stack2.pop());
//        }
//        stack1.push(x);
//    }
//    public Integer poll() {
//        if (stack2.isEmpty()) {
//            return null;
//        }
//        while (!stack1.isEmpty()) {
//            stack2.push(stack1.pop());
//        }
//        return stack2.pop();
//    }
//
//    public Integer peak() {
//        return stack2.peek();
//    }

    // 两队列实现栈
    public Queue<Integer> queue1 = new LinkedList<>();
    public Queue<Integer> queue2 = new LinkedList<>();
    public void push(int x) {
        queue1.offer(x);
    }
    public Integer pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return null;
        }
        while (queue1.size() > 1) {
            // 将A中的元素放入B中
            Integer cur = queue1.poll();
            queue2.offer(cur);
        }
        int ret = queue1.poll();
        swap();
        return ret;
    }

    private void swap() {
        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }
}
