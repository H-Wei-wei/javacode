import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sort {

    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            B[i] = func(A, i);
        }
        return B;
    }

    private int func(int[] A, int i) {
        int res = 1;
        for (int j = 0; j < A.length; j++) {
            if (i != j) {
                res *= A[j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Map<Character, Integer> map = new HashMap<>();
            String s = sc.nextLine();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.get(c) == null) {
                    map.put(c, 1);
                }else {
                    map.put(c, map.get(c) + 1);
                }
            }
            for (Map.Entry<Character, Integer> entry: map.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
    }
}
