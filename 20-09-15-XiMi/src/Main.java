import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int size = 1;
    static int[] array = new int[size];
    static int[] primeFactorization(int num, int n) {
        if (num == 1) {
            size++;
            array[size - 1] = 1;
            return array;
        }
        if (isTrue(num) && num%n == 0) {
            size++;
            array[size - 1] = n;
            num = num/n;
            primeFactorization(num, n);
        }else {
            n++;
            primeFactorization(num,n);
        }
        return array;
    }
    static boolean isTrue(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] res;

        int _num;
        _num = Integer.parseInt(in.nextLine().trim());

        res = primeFactorization(_num,2);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}
