
import java.util.Scanner;

public class TestDemo {
	
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int ret = sum(n);
		System.out.println(ret);
	}
	/* //迭代-》循环
	public static int sum(int n) {
		int ret = 0;
		for(int i = 0; i <= n;i++) {
			ret += i;
		}
		return ret;
	} */
	//递归
	public static int sum(int n) {
		if(n == 0) {
			return 0;
		}
		int ret = 0;
		ret = n + sum(n-1);
		return ret;
	}
	
	//重载(overlaod)-------------重写（override）
	//重载-针对同一个类
	//		1、方法名相同
	//		2、方法的参数不同（参数个数或参数类型）
	//		3、方法的返回值类型不影响重载
	public static void main6(String[] args) {
		int a = 10;
		int b = 20;
		int ret = add1(a,b);
		System.out.println(ret);
		
		double c = 23.4;
		double d = 23.6;
		double ret2 = add1(c,d);
		System.out.println(ret2);
	}
	public static int add1(int a,int b) {
		return a + b;
	}
	public static double add1(double a,double b) {
		return a + b;
	}
	
	public static void swap(int a,int b) {
		int tmp = 0;
		tmp = a;
		a = b;
		b = tmp;
		System.out.println("a = "+a+" "+"b = "+b);
	}
	public static void main5(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		swap(a,b);
		//System.out.println("a = "+a+" "+"b = "+b);
	}
	
	public static int add(int n1,int n2) {
		return n1 + n2;
	}
	
	public static void main4(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		int ret = add(n1,n2);
		System.out.println(ret);
	}
	
	public static int addSum(int n) {
		int sum = 0;
		for(int i = 0; i <= n; i++) {
			sum +=i;
		}
		return sum;
	}
	
	public static void main3(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int ret = addSum(n);
		System.out.println(ret);
	} 
	
	public static int fac(int n) {
		if(n == 1) {
			return 1;
		}
		int ret = n*fac(n-1);
		return ret;
	}
	
	public static int facSum(int n) {
		int sum = 0;
		for(int i = n; i >= 1; i--) {
			sum += fac(i);
		}
		return sum;
	}
	
	public static void main2(String[] args) {
	    Scanner scan = new Scanner(System.in); 
	    int n = scan.nextInt();
		int ret = facSum(n);
		System.out.println(ret);
	}

	//public static int facSum(int x) {
		
	//}
	
	//public static void main2(String[] args) {
	//	Scanner scan = new Scanner(System.in);
	//	
	//	int ret = facSum;
	//	System.out.println(ret);
	//}
	
	public static int maxNum1(int a,int b) {
		return (a > b ? a : b);
	}
	
	public static int maxNum2(int a,int b,int c) {
		//int max = (a > b ? a : b);
		//int max2 = (max > c ? max : c);
		//return max2;
		
		int max = maxNum1(maxNum1(a,b),c);
		return max;
	}

	public static void main1(String[] args) {
		//int a = 3;
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		int n3 = scan.nextInt();
		
		int ret1 = maxNum1(n1,n2);
		int ret2 = maxNum2(n1,n2,n3);
		System.out.println(" 两个数的最大值"+ret1);
		System.out.println(" 三个数的最大值"+ret2);
	}
}