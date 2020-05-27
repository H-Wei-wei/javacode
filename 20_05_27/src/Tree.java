import java.util.Scanner;

public class Tree {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int sum = 0;
        int num = 1 ;
        for (int i = 1; i <= x; i++) {
            num = 1;
            for (int j = 1; j <= i; j++) {
               num = num * j;
            }
            sum = sum + num;
        }
        System.out.println(sum);
    }

    public class Solution {
        public void reOrderArray(int [] array) {
            //相对位置不变，稳定性
            //插入排序的思想
            int m = array.length;
            int k = 0;//记录已经摆好位置的奇数的个数
            for (int i = 0; i < m; i++) {
                if (array[i] % 2 == 1) {
                    int j = i;
                    while (j > k) {//j >= k+1
                        int tmp = array[j];
                        array[j] = array[j-1];
                        array[j-1] = tmp;
                        j--;
                    }
                    k++;
                }
            }
        }
    }


}

