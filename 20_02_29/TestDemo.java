


//小类型给大类型赋值，无需类型转换---隐式类型转换
//
//boolean   布尔类型 不能和其他类型发生转换
//
//byte 和  char 不管从大到小还是从小到大 都需要进行强制类型转换
//short 和 char  两个类型字节都一样，但也需要强制类型转换
//               原因：1、本质上shar字符型，short是整型，之间不建议转换
//                     2、char类型，字符对应十进制，是没有负数的，而
//                         short类型的有----精度不同      
//
public class TestDemo {

    public static void main(String[] args) {
      //short char
      short sh = 10;
      char ch = '高';
      //sh = (short)ch;
      ch = (char)sh;
      //System.out.println(sh);
      System.out.println(ch);


    }

    public static void main12(String[] args) {
         //byte   char
      byte b = 10;
      char ch = '高';
      //找的是9所对应的字符
      //char ch2 = 9;
      //b = (byte)ch;
      ch = (char)b;
      System.out.println(b);
      System.out.println(ch);
      //System.out.println(ch2);

    }

   //成员变量
   //类的属性：定义在类的里，但在方法外
   //          是有初始值的
           
    public static boolean flg;  //boolean默认值是false
    public static char flg1;   //char->'\u0000
    public static int flg2;    //int ->0
    public static double flg3;  //double->0.0


    public static void main11(String[] args) {
       //int a = 10;
       //System.out.println(a);
       System.out.println(flg);
       System.out.println(flg1);
       System.out.println(flg2);
       System.out.println(flg3);

    }

    public static void main10(String[] args) {
        //String -》int
        String s1 = "12";
        int a = Integer.parseInt(s1);
        System.out.println(a); 

    }

	  public static void main9(String[] args) {
        //int -》string
        int a = 10;
        String s1 = a + " ";
        System.out.println(s1); 
        //String.valueOf -> 将参数转换为字符串
        String s2 = String.valueOf(12.5);
        System.out.println(s2); 

    }

	  public static void main8(String[] args) {
        int a = 10;
        long b = 12L;
        //不同类型的参与运算，提升为较大的类型
        int c = (int)(a+b);
        long d = a+b;
        System.out.println(d); 
        int m = 10;
        int n = 20;
        int  z = m+n;
        System.out.println(z); 

    }

	  public static void main7(String[] args) {
        double x = 2.0; 
        int y = 4; 
        x /= ++y;
        System.out.println(x);
       // byte a = 1; 
       // float b = 3.5f; 
        int  a = 3;
       // byte b = a;
    }

	  public static void main6(String[] args) {
		short a =128;
        System.out.println(a);
        byte b =(byte)a;
        System.out.println(b);
	  }

   	public static void main5(String[] args) {
       byte a = 10;
       byte b = 12;
       //类型提升   byte提升为int
       byte c = (byte)(a+b);
       System.out.println(c);
       int d = a+b;
       System.out.println(d);
    }

    public static void main4(String[] args) {
       int a = 10;
       //boolean b = true;
       //a = b;
       System.out.println(a);
    }

    public static void main3(String[] args) {
       int a = 10;
       boolean b = true;   //布尔类型和其他类型无法转换
       
       //b = a;
       System.out.println(b);
    }

    public static void main2(String[] args) {
        int a = 10;
        double b = 12.5;  

       // b = a;
        System.out.println(b);
       
        a = (int)b;
        System.out.println(a);
    }

    public static void main1(String[] args) {
        int a = 5;
        long b = 20L;
        // a = (int)b;  //强制类型转换
        // a = b;    //大类型不能赋值给小类型
        b = a;   
        System.out.println(b);
    } 

}