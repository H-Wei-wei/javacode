import java.util.Random;
import java.util.Scanner;


public class Demo1 {
    public static void main(String[] args) {
        int[] array = {3,6,8,2,9,1,7,4,0};
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int ret = func1(array, 5);
        }
    }

    private static int func1(int[] array, int toFind) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (toFind < array[mid]) {
                right = mid - 1;
            }else if (toFind > array[mid]) {
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main5(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int ret = func(a);
            System.out.println(ret);
        }
    }

    private static int func(int a) {
        if (a < 10) {
            return a;
        }
        return a%10 + func(a/10);
    }

    public static void main4(String[] args) {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            if(i%10 == 9) {
                count++;
            }
            if (i/10 == 9) {
                count++;
            }
        }
        System.out.println(count);
    }
    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            while (b != 0) {
                int c = a%b;
                a = b;
                b = c;
            }
            System.out.println(a);
        }
    }
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean flg = false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                flg = true;
                break;
            }
            flg = false;
        }
        if (flg) {
            System.out.println("不是素数");
        }else {
            System.out.println("“是素数");
        }
    }

    /**
     * 猜数字小游戏
     */
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        // 生成随机值
        int value = random.nextInt(100);
        while (true) {
            System.out.print("请输入要猜的数字：");
            int n = sc.nextInt();
            if (n < value) {
                System.out.println("猜小了");
            }else if (n > value) {
                System.out.println("猜大了");
            }else {
                System.out.println("恭喜你猜对了啦");
                break;
            }
        }
    }

}

