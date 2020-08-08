import java.util.Stack;

/**
 * 最小栈问题
 */

public class MinStack {

    // A 中存放数据
    private Stack<Integer> A = new Stack<>();
    // B 中每个元素是 A 中对应元素个数情况下的最小值
    private Stack<Integer> B = new Stack<>();
    // A B 两同时变化
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        A.push(x);
        if (B.empty()) {
            B.push(x);
            return;
        }
        // 当B中不为空时，去除上一轮的最小值
        int min = B.peek();
        if( x < min ) {
            min = x;
        }
        B.push(min);
    }

    public void pop() {
        if (A.empty()) {
          return;
        }
        A.pop();
        B.pop();
    }

    public int top() {
        if (A.empty()) {
            return 0;
        }
        return A.peek();
    }

    public int getMin() {
        if (B.empty()) {
            return 0;
        }
        return B.peek();
    }

}
