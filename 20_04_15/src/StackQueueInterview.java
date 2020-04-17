import java.util.Stack;

/**
 * 括号匹配问题
 */

public class StackQueueInterview {
    public boolean isValid(String s) {
        if(s.isEmpty()) {
            return true;
        }
        // 1、创建一个栈
        Stack<Character> stack = new Stack<>();
        // 2、遍历字符串
        for (int i = 0; i < s.length() ; i++) {
            // charAt 取字符串中字符的下标
            char c = s.charAt(i);
            // a、如果是左括号，就入栈
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }

            //  b、如果是右括号，取栈顶元素进行比较
            if(stack.empty()) {
                return false;
            }
            Character top = stack.pop();
            // 判断括号是否相等
            if(top == '(' && c == ')') {
                continue;
            }
            if(top == '{' && c == '}') {
                continue;
            }
            if(top == '[' && c == ']') {
                continue;
            }
            // 如果前三种情况都没有出现
            return false;
        }
        // 当遍历完字符串时，看栈是否为空
        if(stack.empty()) {
            return true;
        }
        return false;
    }
}
