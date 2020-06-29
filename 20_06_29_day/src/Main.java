import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//怪物数量
            int a = sc.nextInt();//小易初始能力值
            int[] array = new int[n];//每个怪物的防御值
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            int ret = finalEnergy(a,array);
            System.out.println(ret);
        }
    }

    private static int finalEnergy(int a, int[] array) {
        int c = a;//表示当前能量值
        for (int x: array) {
            if (x <= c) {
                c = c + x;
            }else {
                c = c + func(c,x);
            }
        }
        return c;
    }

    //求最大公约数--辗转相除法
    private static int func(int c, int x) {
        int m = c % x;
        while (m != 0) {
            c = x;
            x = m;
            m = c % x;
        }
        return x;
    }
}
