import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main3 {
    public static boolean chkParenthesis(String A, int n) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char ret = stack.pop();
                if (ret != map.get(c)) {
                    return false;
                }
            }else {
                return false;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(chkParenthesis("[()]}", 5));
    }
}
