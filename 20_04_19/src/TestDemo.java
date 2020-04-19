import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 括号匹配问题
 */

public class TestDemo {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // 取出字符串里的字符
            char c = s.charAt(i);

            // 判断是否为左括号，如果是，就入栈
/*
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
                // 结束此次循环，进行下一次循环
                continue;
            }
*/
            if(map.get(c) != null) {
                stack.push(c);
                // 结束此次循环，进行下一次循环
                continue;
            }
            // 如果栈为空
            if (stack.empty()) {
                return false;
            }
            // 如果是右括号，将他与栈顶元素对比
            Character top = stack.pop();
/*
            if(top == '(' && c == ')' ) {
                continue;
            }
            if(top == '[' && c == ']' ) {
                continue;
            }
            if(top == '{' && c == '}' ) {
                continue;
            }
*/
            if (map.get(c).equals(top)) {
                continue;
            }
            return false;
        }

        // 如果栈中没有元素
        if(stack.empty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
