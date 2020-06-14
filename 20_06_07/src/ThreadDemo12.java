import java.util.Scanner;

public class ThreadDemo12 {
    static class Counter {
        public volatile int flag = 0;
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (counter.flag == 0) {

                }
                System.out.println("t1线程结束");
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                Scanner sc = new Scanner(System.in);
                System.out.println("请输入一个数：");
                counter.flag = sc.nextInt();
            }
        };
        t2.start();
    }
}