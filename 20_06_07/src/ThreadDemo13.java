import java.util.Scanner;

public class ThreadDemo13 {
    public static void main(String[] args) {
        Object locker = new Object();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (locker) {
                    while (true) {
                        try {
                            System.out.println("wait开始");
                            locker.wait();
                            System.out.println("wait结束'");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                Scanner sc = new Scanner(System.in);
                System.out.println("输入一个数");
                int n = sc.nextInt();
                synchronized (locker) {
                    System.out.println("notify开始执行");
                    locker.notify();
                    System.out.println("notify执行结束");
                }
            }
        };
        t2.start();
    }
}
