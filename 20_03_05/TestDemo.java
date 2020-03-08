

/**
 * 第二个课件的作业
 * 1.交换两个数的值
 * 2.求三个数中的最大值
 */

import java.util.Scanner;

public class TestDemo {
   
    public static void main(String[] args) {
		//工具类：Scanner
        Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		int max1 = a >= b ? a : b;
        int max2 = max1 >= c ? max1 : c ;
		System.out.println(max2);
    }
	
    public static void main2(String[] args) {
        int a = 2;
        int b = 1;
        int c = 3;
		
        int max1 = a >= b ? a : b;
        int max2 = max1 >= c ? max1 : c ;
		System.out.println(max2);
		
		//int max2 = (a >= b? a : b) >= c ? (a >= b? a : b) : c ;
		//System.out.println(max2);
        
		//int max = 0;
		//if(a > b)
		//	max = a;
		//  else 
		//	max = b;
		//if(max > c)
		//    System.out.println(max);
    	//  else 
        //    System.out.println(c);  
    }
   
    public static void main1(String[] args) {
        int a = 2;
		int b = 3;
		int c = 0;
		System.out.println("a = " + a + ",b = "  +b);
		//c = a;
		//a = b;
		//b = c;
		
		//a = a+b;
		//b = a-b;
		//a = a-b;
		
	    c = a^b;
        a = a^c;
		b = b^c;
		System.out.println("a = "+a+",b = "+b);

    }

}

