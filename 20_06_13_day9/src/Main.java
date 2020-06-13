import java.util.Arrays;

public class Main {

    public static String[] getGray(int n) {
        int length = (int) Math.pow(2,n);
        String[] str = new String[length];
        if (n == 1) {
            str[0] = "0";
            str[1] = "1";
            return str;
        }
        String[] ret = getGray(n - 1);
        for (int i = 0; i < length/2; i++) {
                str[i] = "0" + ret[i];
                str[length - 1 - i] = "1" + ret[i];
        }
        return str;
    }

    public static void main(String[] args) {
        String[] ret = getGray(3);
        System.out.println(Arrays.toString(ret));
    }
}
