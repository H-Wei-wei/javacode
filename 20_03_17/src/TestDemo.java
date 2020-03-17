import java.util.Arrays;
import java.util.Scanner;

public class TestDemo {

    //递归方法打印一个数的每一位
    public static void print1(int n) {
        if(n > 10) {
            print1(n/10);
        }
        System.out.println(n%10);
    }
    //迭代方法打印一个数上的每一位
    public static void print(int n) {
        while(n != 0) {
            System.out.println(n%10);
            n /= 10;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        //print(n);
        print1(n);
    }

    //斐波那契数列
    public static int feibonacie(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }
        return feibonacie(n - 1) + feibonacie(n - 2);
    }
    public static void main6(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ret = feibonacie(n);
        System.out.println(ret);
    }

    //输入一个数组 并打印
    public static void main5(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = new int[5];
        for(int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }
        for(int i: array) {
            System.out.print(i+" ");
        }
    }

    public static int jumpStep(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        return jumpStep(n - 1) + jumpStep(n - 2);
    }
    public static void main4(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ret = jumpStep(n);
        System.out.println(ret);
    }

    //空引用————null
    //表示这是个无效的内存位置，不能对其进行读取操作
    public static void main3(String[] args) {
        int[] array = null;
        //System.out.println(array[0]);
    }

    public static void func(int[] array) {
        //int[] ret = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            array[i] = 2 * array[i];
        }
    }
    public static void main2(String[] args) {
        int[] array = {1,2,3,4};
        func(array);
        System.out.println(Arrays.toString(array));
    }

    public static void swap(int a, int b) {
        int tmp = a;
        tmp = a;
        a = b;
        b = tmp;
    }
    public static void main1(String[] args) {
        int a = 10;
        int b = 20;
        swap(a,b);
        System.out.println("a = "+a+" "+"b = "+b);
    }
}
