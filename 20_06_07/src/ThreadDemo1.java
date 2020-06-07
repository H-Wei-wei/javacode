
public class ThreadDemo1 {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("hello world，我是一个新线程");
            while (true) {

            }
        }
    }

    public static void main(String[] args) {
        // 创建线程首先得使用一个 Thread 类，来创建一个 Thread 的实例
        // 另一方面还需要指定该线程要执行哪些指令
        // 指定指令有多种方法，这里使用最简单的，直接继承 Thread 类
        // 重写 run 方法

        // 当 Thread 对象被创建出来，内核中并没有随之产生一个线程（PCB）
        Thread t = new MyThread();
        // 当执行这个 start 才在内核中创建线程，在内核中创建一个 PCB，让对应的CPU来执行该线程的程序
        t.start();
        while (true) {

        }

    }
}
