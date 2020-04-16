
/**
 * 顺序表（数组）实现栈
 */

public class MyStack {
    // 定义一个数组存放数据
    private int[] array  = new int[100];
    // 栈的大小 [0,size)
    private int size = 0;

    // 入栈操作
    private void push(int value){
        array[size] = value;
        size++;
    }

    // 出栈
    private Integer pop() {
        if(size <= 0) {
            return null;
        }
        int ret = array[size-1];
        size--;
        return ret;
    }

    // 取栈顶元素
    private Integer peak() {
        if (size <= 0) {
            return null;
        }
        return array[size-1];
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        // 入栈
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        System.out.println("取栈顶元素"+myStack.peak());
       // 出栈
        while(true) {
            Integer cur = myStack.pop();
            if(cur == null) {
                break;
            }
            System.out.println(cur);
        }

        System.out.println("取栈顶元素"+myStack.peak());

    }
}
