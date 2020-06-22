import java.util.Arrays;

public class Main1 {
    public static boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] arr=new boolean[n];
        for (int i = 0; i < n; i++) {
            if (s.contains(p[i])) {
                arr[i] = true;
            }else {
                arr[i] = false;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        String[] p = {"a", "ab", "d"};
        String s = "abc";
        System.out.println(Arrays.toString(chkSubStr(p, p.length, s)));
    }
}
