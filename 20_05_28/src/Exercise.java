import java.util.Arrays;

public class Exercise {
    // 递归
    public static int fac (int n) {
        if (n == 1) {
            return 1;
        }
        return n * fac(n-1);
    }

    // 按顺序打印一个数的每一位
    public static void print(int n) {
        if (n > 9) {
            print(n / 10);
        }
        System.out.println(n % 10);

    }

    // 1+2+3+4+6……
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n-1);
    }

    // 1234  --> 1+2+3+4
    public static int sum1(int n) {
        if (n < 10) {
            return n;
        }
        return n % 10 + sum1(n / 10);
    }

    // 斐波那契 ---- 不适合用递归
    public static int fabonaci(int n) {
        if (n ==1 || n == 2) {
            return 1;
        }
        return fabonaci(n - 1) + fabonaci(n - 2);
    }
    public static int fabonaci1(int n) {
        int num1 = 1;
        int num2 = 1;
        int fn = 1; // 如果 n == 1 或 n == 2 时，fn = 1;
        for (int i = 3; i <= n; i ++) {
            fn = num1 + num2;
            num1 = num2;
            num2 = fn;
        }
        return fn;
    }

    // 汉诺塔问题
    public static void hanoi(int n, char post1, char post2, char post3) {
        if (n == 1) {
            move(post1, post3);
            return;
        }
        hanoi(n-1, post1, post3, post2);
        move(post1, post3);
        hanoi(n - 1, post2, post1, post3);
    }
    private static void move(char post1, char post2) {
        System.out.print(post1 + "->" + post2 +" ");
    }

    // 青蛙跳台阶问题 --- 一次只能跳一节或是两节
    public static int jumpStep(int n) {
        if (n == 1) {
            return 1;
        }else if (n == 2) {
            return 2;
        }else {
            return jumpStep(n - 1) + jumpStep(n - 2);
        }
    }
    // 青蛙一次可以跳 1 ~ n 个台阶
    public static int jumpStep2(int n ) {
        if (n == 1) {
            return 1;
        }
        return 2 * jumpStep2(n - 1);
    }


    public static void reOrderArray(int [] array) {
        for (int bound = 0; bound < array.length; bound++) {
            int tmp = array[bound];
            // 找到数组的第一个奇数
            if (array[bound] % 2 == 1) {
                int cur = bound - 1;
                // 判断该奇数前边是否有偶数，有的话，交换位置
                for (; cur >= 0; cur--) {
                    if (array[cur] % 2 == 0) {
                        array[cur + 1] = array[cur];
                    }else {
                        break;
                    }
                }
                array[cur + 1] = tmp;
            }
        }
    }
    public static void swap(int[] array , int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void main(String[] args) {
        //System.out.println(fac(5));
        //print(123);
        //System.out.println(fabonaci1(50));

/*       hanoi(1, 'A', 'B', 'C');
        System.out.println();
        hanoi(2, 'A', 'B', 'C');
        System.out.println();
     hanoi(3, 'A', 'B', 'C');
*/
        //System.out.println(jumpStep(4));

        //System.out.println(jumpStep2(4));
        int[] array = {1,3,2,5,6,7,4};
        reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }
}
