
/**
 * 逻辑循环
 * 
 * 顺序循环
 * 分支循环（单、双、多）
 * if 、 switch
 * 循环结构
 */
import java.util.Scanner;

public class TestDemo1 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    switch(n) {
      case 1:
        System.out.println("星期一");
        break;
      case 2:
        System.out.println("星期二");
        break;
      case 3:
        System.out.println("星期三");
        break;
      case 4:
        System.out.println("星期四");
        break;
      case 5:
        System.out.println("星期五");
        break;
      case 6:
        System.out.println("星期六");
        break;
      case 7:
        System.out.println("星期日");
        break;
      default:
        System.out.println("输入有误");
        break;
    }
  }

  public static void main8(String[] args) {
    int x = 10;
    int y = 10;
    if (x == 10) {
      if (y == 20) {
        System.out.println("aaa");
      }else {
        System.out.println("bbb");
      }
    }
  }

  /**
   * 判断哪一年是闰年
   * year能被4整除但不能被一百整除的
   * year能被400整除
   * @param args [description]
   */
  public static void main7(String[] args) {
    Scanner scan = new Scanner(System.in);
    int year = scan.nextInt();
    if((year % 4 == 0) && (year %100 != 0) ||(year % 400 == 0)) {
      System.out.println("当前"+year+"是闰年");
    }else {
       System.out.println("当前"+year+"不是是闰年");
    }
  }

  public static void main6(String[] args) {
    Scanner scan = new Scanner(System.in);
    //循环读取
    //ctrl+z   正常停止
    //ctrl+c   中断
    while(scan.hasNext()) {
      int n = scan.nextInt();
      if(n < 0) {
        System.out.println("n是负数");
      }else if(n > 0) {
       System.out.println("n是正数");
      }else {
      System.out.println("n是0");
      }
    }

  }

  /**
   * 判断一个数是负数还是正数
   * @param args [description]
   */
  public static void main5(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    if(n < 0) {
      System.out.println("n是负数");
    }else if(n > 0) {
      System.out.println("n是正数");
    }else {
      System.out.println("n是0");
    }

  }
  /**
   * 输入一个数，判断该数字是寄数还是偶数
   * @param args [description]
   */
  public static void main4(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    if( n % 2 == 0) {
      System.out.println("当前数是偶数");
    }
    System.out.println("当前数是寄数");
  }

  public static void main3(String[] args) {
    int a = 10;
    if(a == 10){
      System.out.println("a == 10");

    }
  }

  public static void main2(String[] args) {
    int a = 5;
    //C语言中，0为真，非零为假
    //java中，真是true，假就是false
      
    //单分支结构
    //if(a == 10) {
    // System.out.println("真");
    //}

    //双分支
    //if(a == 10) {
    //  System.out.println("真");
    //}else {
    //  System.out.println("假");
    //}

    //多分支
    if(a == 10) {
      System.out.println("a ==10");
    }else if(a == 20) {
      System.out.println("a == 20");
    }else {
      System.out.println("a != 10 && a != 20");
    }
  }

	public static void main1(String[] args) {
    //顺序结构
    System.out.println("1");
    System.out.println("2");
    System.out.println("3");
    System.out.println("4");
    System.out.println("5");

	}

}