import java.util.Arrays;
import java.util.Scanner;

public class TestDemo {

    
    /**
     * 打印数组的三种方式
     * 1、for循环
     * 2、foreach
     * 3、Array.toString()
     * @param args
     */
    public static void main4(String[] args) {
        int[] array1 = new int[3];//定义————数组里的值初始化为0
        int[] array2 = {1,2,3,4,5,6,7,8,9,10};//定义且初始化一个数组
        int[] array3 = new int[] {1,2,3,4,5,6,7,};//定义且初始化一个数组

        for(int i = 0; i < array2.length; i++) {
            System.out.print(array2[i]+" ");
        }
        System.out.println();
        for(int i : array2) {
            System.out.print(i+" ");
        }
        //将数组内容按字符串输出
        System.out.println();
        System.out.println(Arrays.toString(array2));
    }

    //青蛙跳台阶问题
    public static int jumpStep(int n) {
       if(n == 1) {
           return 1;
       }
       if(n == 2) {
           return 2;
       }
       return jumpStep(n - 1) + jumpStep(n - 2);
    }
    public static void main3(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ret = jumpStep(n);
        System.out.println(ret);
    }

    //汉诺塔问题
    public static void move(char pos1,char pos3) {
        System.out.print(pos1 + "->"+pos3+" ");
    }
    public static void hanoi(int n, char pos1, char pos2, char pos3) {
        if(n == 1) {
            move(pos1,pos3);
            return;
        }
        hanoi(n-1,pos1,pos3,pos2); //开始位置，中途转接位置，目的地
        move(pos1,pos3);
        hanoi(n-1,pos2,pos1,pos3);//开始位置，中途转接位置，目的地
    }
    public static void main2(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();*/
        hanoi(1,'A','B','C');
        System.out.println();
        hanoi(2,'A','B','C');
        System.out.println();
        hanoi(3,'A','B','C');
        System.out.println();

    }

    public static int fabonacio1(int n) {
        int f1 = 1;
        int f2 = 1;
        int f3 = 0;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
    public static int fabonacio2(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }
        return fabonacio2(n-1) + fabonacio2(n -2);
    }
    //斐波那契数列
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ret1 = fabonacio1(n);
        System.out.println(ret1);
        int ret2 = fabonacio2(n);
        System.out.println(ret2);
    }
}
