
import java.util.*;
public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String res = "";//用来记录被选到的数
        int sum = 0; //用来记录被选到数加起来的总和
        int []num = new int[n];
        int j =1;
        for(int i = 0;i < n;i++)
            num[i] = j++;
        process(num,m,res,sum,0);
    }

    public static void process(int[] num,int m,String res,int sum,int i){
        if(i == num.length){
            if(sum == m)
                //这里用trim（）方法就是去除每个输出最后的一个空格
                System.out.println(res.trim());
            return;
        }
        //表示我将num[i]这个数选到了
        process(num,m,res+num[i]+" ",sum+num[i],i+1);

        //表示我不要num[i]这个数
        process(num,m,res,sum,i+1);
    }
}