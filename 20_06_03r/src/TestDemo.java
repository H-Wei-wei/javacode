import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TestDemo {

    public static boolean chkParenthesis(String A, int n) {

        Map<Character,Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // 1.取字符串第 i 个字符
            char c = A.charAt(i);
            // 2.如果 c 是左括号就入栈
            if (c =='(' || c == '{' || c == '[') {
                stack.push(c);
                // 3.如果 c 是右括号
            }else if (c == ')' || c == '}' || c == ']') {
                // 就拿 c 在 map 中获取 value 值和栈顶元素进行比较，并将栈顶元素出栈
                if (!stack.isEmpty()) {
                    char tmp = stack.pop();
                    // 如果括号配对成功，就结束此次循环，进入下一次循环
                    if (map.get(c) == tmp) {
                        continue;
                    }
                }
                // 如果匹配失败，或者栈为空， 就说明此字符串不合法
               return false;
            }else {
                // 4.如果该字符不是题中要求的括号，也说明此括号序列不合法
                return false;
            }
        }
        // 5.如果字符串循环结束后，栈中还有未配对的括号，也说明此括号序列不合法
        //    栈为空，说明序列合法，返回 true；
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "()())";
        System.out.println(chkParenthesis(s, s.length()));
    }
}
