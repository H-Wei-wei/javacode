import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BrokenKeyBoard {
    public static void main(String[] args) {
        // 1.处理输入输出
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 预期值
            String expected = scanner.next();
            // 实际输出
            String actual = scanner.next();
            // 2.转成大写
            expected = expected.toUpperCase();
            actual = actual.toUpperCase();
            // 3.将实际字符加入到 Set 中
            Set<Character> setActual = new HashSet<>();
            for (int i = 0; i < actual.length(); i++) {
                setActual.add(actual.charAt(i));
            }
            // 4. 遍历预期输出的字符，看 SetActual中是否包含，不包含就代表是坏了的键盘
            Set<Character> brokenKey = new HashSet<>();
            for (int i = 0; i < expected.length(); i++) {
                char c = expected.charAt(i);
                if (setActual.contains(c)) {
                    // 包含就继续下一个字符判定
                    continue;
                }
                // 不包含 就打印出来
                if (brokenKey.contains(c)) {
                    continue;
                }
                System.out.print(c);
                brokenKey.add(c);
            }
            System.out.println();
        }
    }
}
