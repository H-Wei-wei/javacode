
public class TestDemo {
	
	public static void main(String[] args) {
		int a = 10;
		System.out.println(a);
		a = 99;
		System.out.println(a);
		System.out.println("=============");
		//final 修饰常量  其值不能改变
		final int SIZE = 200;   
		//SIZE = 100; error
		System.out.println(SIZE);

		final int SIZE2;
		SIZE2 = 100;
		//SIZE2 = 3300;error
		System.out.println(SIZE2);
	}
	
	public static void main9(String[] args) {
		//在屏幕上打印出   "hello"  \  ->转义  \"==>"
		String s = "\"hello\"";  // "hello"
		System.out.println(s);
		String m = "\\hello\\";  // \hello\
		System.out.println(m);
	}
	
	public static void  main8(String[] args)  {
	    //字符串类型  C：没有字符串类型的 char *p = "abcdef";
		//String 
		String s = "abcdef";
		System.out.println(s);//abcdef
		
		int a = 10;
		System.out.println("a = " + a);// a == 10

		int c = 20;
		System.out.println( a + c);//30
		System.out.println("a+c = " + a + c);//a+c = 1020
		System.out.println("a+c = " + (a + c));//

		System.out.println("a = " + a +",c = "+ c);

		
		System.out.println("a+c = " + a + " " + c);//a+c = 10 20

		//+  =>拼接  如果是(字符串 + 任意数据类型)-》整体字符串
		double d = 12.5;
		System.out.println("gaobo = " + d);//gaobo = 12.5
	
	}
	
	public static void  main7(String[] args)  {
		//布尔类型  boolean  JVM并没有规定其大小   只有两个取值
		//true  false   在Java当中 没有所谓的0就是假  非0就是真这个概念
		//Java里面真有一个那就是true  假只有一个那就是false
		//C : 弱类型语言    Java：强类型语言
		
		boolean b = true;
		System.out.println(b);
		
	}
	
	public static void  main6(String[] args)  {
		//short 短整型   2字节
	    //-32768‬ -  32767
		short s = 32767;
		System.out.println(s);
		System.out.println(Short.MAX_VALUE);
	}
	
	public static void  main5(String[] args)  {
		//byte  字节型   1字节  
		//-128   127
		//总结来说，给变量赋值的时候，赋值的值不能够超过
		//其能够表达的范围
		
		byte a = 127;
		System.out.println(a);
		
        //byte b = Byte.MAX_VALUE+1; //error
		//System.out.println(b);
		
		//System.out.println(Byte.MAX_VALUE+1);
		
		System.out.println(Byte.MAX_VALUE);  //127
		System.out.println(Byte.MIN_VALUE);  //-128
		
		int c = 2147483647;
		System.out.println(c);

		int d = Integer.MAX_VALUE+1;
		System.out.println(d);
		System.out.println(Integer.MAX_VALUE+1);
	}
	
	public static void  main4(String[] args)  {
		//char  字符型   2字节  C: asscii字符集  Java：Unicode字符集
		char a = 'a';
		System.out.println(a);
		int b = a;
		System.out.println(b);
	 }
	 
    public static void  main3(String[] args)  {
		//float  单精度浮点数     4字节
		//float a = 12.5;  //error
		float a = 12.5f;
		System.out.println(a);
	}
	
	public static void  main2(String[] args)  {
		//double  双精度浮点数类型  8字节  
	    double a=1.1;  
        double b=1.1;
		System.out.println(a/b);
		System.out.println(a*b);
		
		double c = 1.0;
		double d = 2.0;
		System.out.println(c/d);
	    int m=1;
	    int n=2;
		System.out.println(m/n);
		//两个整型如果相除，并不会保存小数
		
	}
	
	public static void  main1(String[] args) {
		//int 整形    4字节   // 局部变量要初始化
		int a=10;   
		System.out.println("a="+a);  //a=10
	    System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		//long 长整形 8字节
		long b=5L;   
		System.out.println("b="+b);  //b=5
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);
		
		System.out.println(Long.MAX_VALUE+1);
		
		double c=12.5;
		System.out.println("c="+c);
	}
}