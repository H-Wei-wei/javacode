import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            double ret = count(n)/fac(n);
            System.out.printf("%.2f", 100 * ret);
            System.out.println("%");
        }
    }
    //计算无人获奖组的个数，得到分母
    public static double count(int n) {
        if(n==1){
            //n=1的时候返回0
            return 0;
        }
        if(n==2) {
            //n=2的时候返回1
            return 1;
        }
        //递归。
        return (n-1)*(count(n-1)+count(n-2));
    }
    //下面的函数用来求阶乘，得到分母
    public static double fac(int n){
        if(n==0){
            //0的阶乘等于1，不用多说吧
            return 1;
        }else{
            //阶乘表示，进行递归
            return n*fac(n-1);
        }
    }
}
