//import java.util.Arrays;

public class TestDemo {

    public static int sum1(int[] array) {
        int ret = 0;
        for (int x : array) {
            ret += x;
        }
        return ret;
    }

    //可变参数编程
    public static int sum(int... array) {
        int ret = 0;
        for (int x : array) {
            ret += x;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(sum(array));

        // 匿名数组
        System.out.println(sum1(new int[]{1,2,3}));

        System.out.println(sum(1, 2, 3, 4, 5));
    }
}

