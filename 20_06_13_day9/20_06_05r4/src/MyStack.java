
/**
 * 用顺序表来实现栈
 */

public class MyStack {
   int[] array = new int[100];
    int size = 0;

    // 入栈
    public void push(int x) {
        array[size] = x;
        size++;
    }
    // 取栈顶元素
    public  int peak() {
        return array[size - 1];
    }
    // 出栈
    public int pop() {
        int ret = array[size - 1];
        size--;
        return ret;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        System.out.println(stack.peak());
        while (stack.size != 0) {
            System.out.print(stack.pop() + " ");
        }
    }

}
