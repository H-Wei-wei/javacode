
import java.util.Scanner;

public class TestDemo {
	//求每一位上的数之和
    //1234 ———— 4 + 3 + 2 + 1 = 10
    public static int sum1(int n) {
		if(n == 0) {
            return 0;
        }
		return(n%10+sum1(n / 10));//error

    }
    public static void main3(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ret = sum1(n);
        System.out.println(ret);
    }
	/* 
	//有问题	
	public static int print1(int n) {
		int ret = 0;   //n = 1234
		if(n > 10) {
			print1(n/10);
		}
		ret = n%10;
		return (n%10 + ret);
	}
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int sum = print1(n);
		System.out.println(sum);
	 } */
	
	public static void print(int n) {
		if(n > 10) {
			print(n/10);
		}
		System.out.println(n%10);
	}
	public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        print(n);
	 }
	 
	public static void main1(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(addSum(n));
	}
	public static int addSum(int n) {
		int sum = 0;
		int ret = 0;
		if(n > 9) {
			ret = addSum(n/10);
			
		}
		sum = ret + n % 10;
		return sum;
	}
}