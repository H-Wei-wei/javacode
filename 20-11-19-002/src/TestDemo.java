
public class TestDemo {
    // 阶乘
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // 求第n个斐波那契数
    public static int fibonacci(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // 汉诺塔(移动次数)
    public static void hanoi(int n, int from,int to) {
        if (n < 1) {
            throw new IllegalArgumentException("n必须大于1 n = " + n);
        }
        if (n == 1) {
            System.out.println("将一个盘子，直接从" + from + "移动到" + to);
            return;
        }
        int other = (0 + 1 + 2) - from - to;
        hanoi(n - 1, from, other);
        System.out.println("将一个盘子，直接从" + from + "移动到" + to);
        hanoi(n - 1, other, to);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorial(n));
        System.out.println(fibonacci(n));
        hanoi(3, 0, 2);
    }
}
