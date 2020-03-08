/**
 * 循环结构
 */
 
import java.util.Scanner;
 
public class TestDemo2 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double sum = 0.0;
		int num = 0;
		while (scan.hasNextDouble()) {
		    double tmp = scan.nextDouble();
			sum += tmp;
			num++;//记录输入多少个数据
		}
		//求和
		System.out.println("sum = " + sum);
		//求平均数
		System.out.println("avg = " + sum / num);
		scan.close();//关闭读入
	}
	
	public static void main8(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//int n = scan.nextInt();
		//System.out.println(n);
		
		//double n= scan.nextDouble();
		//System.out.println(n);
		
		//float n = scan.nextFloat();
		//System.out.println(n);
		
		String n = scan.nextLine();
		System.out.println(n);
	}
	
	public static void main7(String[] args) {
		System.out.println("呵呵");
		System.out.print("呵呵 ");
		System.out.printf("%d\n",10);
	}
	
	public static void main6(String[] args) {
		/* for(int i = 100; i <= 200;i++) {
			if(i%3 == 0) {
				System.out.print(i+" ");
			}
		} */
		int num = 100;
		while(num <= 200) {
			if(num%3 != 0) {
				num++;
				continue;
			}
			System.out.print(num+" ");
			num++;
		}
	}
	
    public static void main5(String[] args) {
	    for(int i = 100; i <= 200;i++) {
			if(i%3 == 0) {
				System.out.println(i);
				break;
			}
		}
	}
	
    public static void main4(String[] args) {
		/* int num = 1;
		int sum = 0;
		while(num <= 5) {
			int j = 1;
			int fac = 1;
			while(j <= num) {
				fac *= j;
				j++;
			}
			sum += fac;
			num++;
		} 
		System.out.println(sum);*/
		
		int sum = 0;
		for(int i = 1; i <= 5; i++) {
			int fac = 1;
			for(int j = 1;j <= i; j++) {
				fac = fac * j;
			}
			sum += fac;
		}
		System.out.println(sum);
	}
	
	public static void main3(String[] args) {
		int n = 1;
		int fac = 1;
		while(n <= 5) {
			fac *= n;
			n++;
		}
		System.out.println(fac);
	}
	
    public static void main2(String[] args) {
		//1~100的和
		int num = 0;
		int sum = 0;
		while(num <= 100) {
			sum += num;
			num++;
		}
		System.out.println(sum);
	}
	
    /**
     * while(表达式)
     * { 循环体;}
     * @param args [description]
     */
	public static void main1(String[] args) {
        int num = 1;
        while(num <= 10) {
            System.out.println(num);
            num++;	
		}			
    }
}
