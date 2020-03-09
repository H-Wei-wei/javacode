
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class TestDemo {
	
	public static void main10(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    int a = scan.nextInt(); 
		int count = 0;
		while(a != 0) {
			if((a&1) == 1) {
				count++;
			}
			a = a>>>1;
		}
		System.out.println("二进制数中1的个数"+count);
	}
	
	public static void main9(String[] args) {
	    //求两数的最小公约数-----辗转相除法
	    Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();  //18
		int b = scan.nextInt();  //24
		int c = a%b;   //18
		while(c != 0) {
			a = b;   //24
			b = c;
			c = a%b;
		}
		System.out.println("最大公约数是"+b);
	}
	
	public static void main8(String[] args) {
		double sum = 0;
		int flg = 1;
		for(int i = 1; i <= 100; i++) {
			sum += 1.0/i*flg;
			flg = -flg;
		}
		System.out.println(sum);
	}
	
	public static void main7(String[] args) {
	    int i = 0;
		for(i = 1 ;i <= 99999; i++) {
			//1、先判断该数的位数
			int count = 0;
	        int num = i;
			while(num != 0) {
				num = num / 10;
				count++;
			}
			//2、再求数的每一位，进行^count运算，并求和
			num = i;
			int sum = 0;
			while(num != 0) {
				sum += Math.pow( num%10,count);
		        num = num/10;
			}
			//3、比较
			if(i == sum) {
		       System.out.println(i+"是要找的数");		
			}
		}
	}
	
	public static void main6(String[] args) {
	    Scanner scan = new Scanner(System.in);
		Random random = new Random();
		int rand = random.nextInt(100);
		while(true) {
			int num = scan.nextInt();
			if(num < rand) {
				System.out.println("猜小了");
			}else if(num == rand) {
				System.out.println("恭喜你猜对了！");
				break;
			}else if(num > rand) {
				System.out.println("猜大了");
			}
		}
	}
	
	public static void main5(String[] args) {
	    Scanner scan = new Scanner(System.in);
		int oldyear = scan.nextInt();
		if(oldyear <= 18) {
			System.out.println("此人是少年");
		}else if(oldyear <=28) {
			System.out.println("此人是青年");
		}else if(oldyear <= 55) {
			System.out.println("此人是中年");
		}else {
			System.out.println("此人是老年");
		}
	}
	
	public static void main4(String[] args) {
	    Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int i = 0;
		for(i = 2;i < a; i ++) {
			if(a % i == 0) {
				break;
			}
		}
		if(i >= a) {
			System.out.println(a+"是素数");
		}
	    
	}
	
	 public static void main3(String[] args) {
	    int i = 0;
		int j = 0;
		for(i=1; i<=100; i++) {
			for(j = 2; j < i ; j++) {
				if(i%j == 0) {
					break;
				}
			}
			if(j >= i) {
				System.out.print(i+" ");
			}
		}	
	} 
	
	public static void main(String[] args) {
		int i = 0;
		int count = 0;
		for(i = 0; i <=100; i++) {
			if(i%10 == 9) {  //个位
				count++;
			}
			if(i/10 == 9) {  //十位
				count++;
			}
		}
		System.out.println("1-100中9的个数为"+count);
	}
	
	public static void main2(String[] args) {
		int year = 0;
		for(year = 1000; year <=2000; year++) {
			if((year % 4 == 0) && (year % 100 != 0) ||(year % 400 == 0)) {
			  System.out.print(year+" ");
			}
			
		//}
		//for(year = 1000; year <=2000; year++){
		//	if(year % 4 == 0){
		//		if(year % 100 != 0) {
		//				System.out.print(year+" ");
		//		}
		//	}
		//	if( year % 400 == 0) {
		//		System.out.print(year+" ");
		//	}
		
		}
	}
	
}