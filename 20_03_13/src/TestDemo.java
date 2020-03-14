import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Arrays;

public class TestDemo {

	public static int[] copyArray(int[] array) {
		int[] ret = new int[array.length];
		for(int i = 0;i < array.length; i++) {
			ret[i] = array[i];
		}
		return ret;
	}

	public static void main8(String[] args) {
	    int[] array = {1,2,3,4,5};
		int[] ret = copyArray(array);
		System.out.print(Arrays.toString(ret));
	}


     //斐波那契数列
    public static int fabonacio(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }
        return fabonacio(n - 1) + fabonacio(n - 2);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ret = fabonacio(n);
        System.out.println(ret);
    }

    //求每一位上的数之和
    //1234 ———— 4 + 3 + 2 + 1 = 10
    public static int sum(int n) {
        if(n < 10) {
            return n;
        }
        return n % 10 + sum(n/10);
    }
    public static void main6(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ret = sum(n);
        System.out.println(ret);
    }

    //递归 ————输出一个数的每一位
    //1234 ———— 1 2 3 4
    public static void print(int n) {
        if(n > 9) {
           print(n / 10);
        }
        System.out.println(n % 10);
    }

    public static void main5(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        print(n);
    }
    //循环————输出一个数的每一位：
    // 1234 ———— 4 3 2 1
    public static void main4(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while(n != 0) {
           int num = n % 10;
           System.out.println(num);
           n = n / 10;
        }
    }

    // 5! = 5*4! = 5*4*3!
    public static int fac(int n) {
        if(n == 1) {
            return 1;
        }
        return n*fac(n-1);
    }
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ret = fac(n);
        System.out.println(ret);
    }

    //5+4+3+2+1
    public static int sumAdd(int n) {
        if(n == 1) {
            return 1;
        }
        return n + sumAdd(n-1);
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
       int ret =  sumAdd(n);
       System.out.println(ret);
    }

    public static void func(int a) {
	    System.out.println(a);
    }
    public static void main1(String[] args) {
        int a = 10;
        int b = 20;
        int c = a + b;
        func(23);
        System.out.println(c);
        System.out.println("HelloIDEA");
    }
}
