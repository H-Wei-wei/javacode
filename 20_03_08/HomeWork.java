
import java.util.Scanner;

public class HomeWork {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i = 1; i <= n; i++) {
			for(int j = 1;j <= i; j++) {
				System.out.print(i+"*"+j+"="+i*j+" ");
			}
			System.out.println();
		}
	}
	
	
	
	public static void main3(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int num = 0;
		
		while(n != 0) {
			num = n % 10;
			System.out.println(num);
			n = n / 10;
		}
	}
	
	public static void main2(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = 1;
		System.out.println("你有三次机会输入密码");
		while(count <= 3) {
			String password = scan.next();
			if(password.equals("abcdef")) {
				System.out.println("密码输入正确！");
				break;
			}else {
				System.out.println("密码输入错误，请重新输入：");
				count++;
			}
		}
	}
	
	public static void main1(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int num = 1;
		
		int m = n;
		System.out.print("二进制数的偶数 ");
		for(int i = 0; i <= 31; i +=2) {
			m = n >>> i;
			num = m & 1;
			System.out.print(num+" ");
		}
		
		System.out.println();
		
		m = n;
		System.out.print("二进制数的奇数 ");
		for(int i = 1; i <= 31; i +=2) {
			m = n >>> i;
			num = m & 1;
			System.out.print(num+" ");
		}
	}
	
}

