
import java.util.Scanner;
import java.io.IOException;
import java.util.Random;
import java.lang.Math;

public class TestDemo {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int count = 0;
		while(n != 0) {
				count++;
				n = n & ( n - 1);
		}
		System.out.println("二进制数中1的个数："+count);
	}
	
	
	public static void main10(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int count = 0;
		while(n != 0) {
			if((n&1) == 1) {
				count++;
			}
			n = n >>> 1;
		}
		System.out.println(count);
	}
	
	public static void main9(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i = 0; i <= n; i++) {
			//判断一个数的位数
			int count = 0;
			int num = i;
			while(num != 0) {
				num = num/10;
				count++;
			}
			//计算出数的每一位的次方和
			int sum = 0;
			num = i;
			while(num != 0) {
				sum += Math.pow(num%10,count);
				num = num / 10;
			}
			//比较sum和n是否相等
			if(sum == i) {
				System.out.println(sum);
			}
		}
	}
	
	public static void main8(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int i = 0;
		for(i = 2; i < Math.sqrt(n); i++) {
			if(n%i == 0) {
				System.out.println(n+"不是素数");
				break;
			}
		}
		if(i >= Math.sqrt(n)) {
				System.out.println(n+"是素数");
		}
	}
	
	public static void main7(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int i = 0;
		for(i = 2; i < n/2; i++) {
			if(n%i == 0) {
				System.out.println(n+"不是素数");
				break;
			}
		}
		if(i >= n/2) {
				System.out.println(n+"是素数");
		}
	}
	
	public static void main6(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int i = 1;
		for(i = 2; i < n; i++) {
			if(n%i == 0) {
				System.out.println(n+"不是素数");
				break;
			}
		}
		if(i >= n) {
				System.out.println(n+"是素数");
		}
	}
	
	public static void main5(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Random random = new Random();
		int rand = random.nextInt(100);
		
		System.out.println("猜数字游戏开始");
		while(true) {
			int num = scan.nextInt();
			if(num < rand) {
					System.out.println("猜小了");
			}else if(num == rand) {
				System.out.println("恭喜你猜对了！");
				break;
			}else {
				System.out.println("猜大了");
			}
		}
	}
	
	public static void main4(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			int n = scan.nextInt();
			System.out.println("整型: "+ n);
		}
		System.out.println("哈哈哈哈");
	}
	
	public static void main3(String[] args) {
	    Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println("整形 "+ n);
		
		String name = scan.next();//遇到空格就结束了
		System.out.println("姓名："+ name);
		
		//nextInt和nextLine 不要放在一起使用
		//原因：nextLine会读取换行符
		//String name = scan.nextline();
		//System.out.println("姓名："+ name);
		
		double d = scan.nextDouble();
		System.out.println("小数"+ d);
		
		scan.close(); //关闭方法
	}
	
	public static void main2(String[] args) {
		System.out.println("请输入一个字符");
		
		try {
			char ch = (char)System.in.read();
		    System.out.println(ch);
		}catch(IOException e) {
			 System.out.println("程序发生异常！！");
		}
	}
	
	public static void main1(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		System.out.println("输出换行!");
		System.out.print("输出不换行! ");
		
		System.out.printf("%s\n","格式输出");
		System.out.printf("%d\n",n);
		System.out.printf("%x\n",n);
	}  
}
