

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 库中的栈和队列
 */

public class TestStackAndQueue {
    public static void main(String[] args) {
        // Stack 是个 class ，即类
        // Stack 继承一个 Vector ，可以使用其的方法
        Stack<String> stack = new Stack<>();


        System.out.println("测试Stack");
        stack.push("我");
        stack.push("喜");
        stack.push("欢");
        stack.push("Java");

        System.out.println("栈顶元素："+stack.peek());

        // 标准库中的 Stack ，
        // 对空栈进行 pop 和 peak 操作时会抛出一个空指针异常
/*        while(true) {
            String cur = stack.pop();
            if(cur == null) {
                break;
            }
            System.out.println(cur);
        }
 */
        while(!stack.empty()) {
            String cur = stack.pop();
            System.out.println(cur);
        }

       /* stack.add(2,"你");
        stack.empty();
        stack.contains("我");*/

        System.out.println("=====================");
        // Queue 是个 interface，
        // 只能实例化一个实现该接口的类
        // Queue 也可以使用 LinkedList 里的方法
        Queue<String> queue = new LinkedList<>();

        System.out.println("测试Queue");
        queue.offer("我");
        queue.offer("喜");
        queue.offer("欢");
        queue.offer("Java");

        System.out.println("queue的队首元素："+queue.peek());

        queue.add("你");
        queue.remove("你");
        while (!queue.isEmpty()) {
            String cur = queue.remove();
           /* if (cur == null) {
                break;
            }*/
            System.out.println(cur);
        }

    }

}
