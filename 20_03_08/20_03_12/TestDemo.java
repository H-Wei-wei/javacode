
import java.util.Scanner;

public class TestDemo {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a = 1;
		int b = 1;
		int c = 0;
		for(int i = 1;i <= n;i++) {
			a = b;
			b = c;
			c = a+b;
		}
		System.out.println(c);
	}
	
	public static void main7(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,4,3,2,1};
        System.out.println(oneShow(arr));
    }
    public static int oneShow(int[] arr){
        int num = 0;
        for(int i = 0;i<arr.length;i++){
            num ^= arr[i];
        }
        return num;
	}
	
 	public static void main6(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		System.out.println("数组长度:"+arr.length);
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 != 0) {
				System.out.print(arr[i]+" ");
			}
		}
		System.out.println();
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 == 0) {
				System.out.print(arr[i]+" ");
			}
		}
	}
	
	public static void main5(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		int ret1 = sum2(n1,n2);
		System.out.println("两整数的和"+ret1);
		
		double n3 = scan.nextDouble();
		double n4 = scan.nextDouble();
		double n5 = scan.nextDouble();
		double ret2 = sum3(n3,n4,n5);
		System.out.println("三小数的和"+ret2);
	}
	public static int sum2(int n1,int n2) {
		return n1 + n2;
	}
	public static double sum3(double n1,double n2,double n3) {
		return n1 + n2 + n3;
	}
	
	public static void main4(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		int ret1 = max2(n1,n2);
		System.out.println("两整数中的最大值"+ret1);
		
		double n3 = scan.nextDouble();
		double n4 = scan.nextDouble();
		double ret2 = max2(n3,n4);
		System.out.println("两小数中的最大值"+ret2);
		
		double n5 = scan.nextDouble();
		double n6 = scan.nextDouble();
		int n = scan.nextInt();
		double ret3 = max(n5,n6,n);
		System.out.println("两小数和一整数中的最大值"+ret3);
	}
	
	public static double max(double n1,double n2,int n) {
		double num =  (n1 > n2 ? n1 : n2);
		return (num > n ? num : n);
	}
	public static double max2(double n1,double n2) {
		return (n1 > n2 ? n1 : n2);
	}
	
	public static int max2(int n1,int n2) {
		return (n1 > n2 ? n1 : n2);
	}
	
	public static int max3(int n1,int n2,int n3) {
		return (max2(n1,n2) > n3 ? max2(n1,n2) : n3);
	}
	public static void main3(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		int n3 = scan.nextInt();
		
		int ret1 = max2(n1,n2);
		System.out.println("两个数的最大值"+ret1);
		
		int ret2 = max3(n1,n2,n3);
		System.out.println("三个数的最大值"+ret2);
	}
	
	public static void main2(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int ret = fac(n);
		System.out.println(ret);
	}
	
	public static int fac(int n) {
		int num = 1;
		for(int i = 1; i <= n; i++) {
			num *= i;
		}
		return num;
	}
	public static int facSum(int n) {
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			int ret = fac(i);
			sum += ret;
		}
		return sum;
	}
	public static void main1(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int ret = facSum(n);
		System.out.println(ret);
	}
}