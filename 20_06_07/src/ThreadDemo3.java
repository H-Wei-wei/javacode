/**
 * 创建新线程
 */
public class ThreadDemo3 {

    // Runnable 本质上就是描述一段要执行的任务代码
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("我是一个新线程");
        }
    }
    public static void main(String[] args) {
        // 1、显示继承 Thread
        // 2、匿名内部类
 /*       Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("我是一个新线程");
            }
        };
        t.start();
 */

        // 3、显示创建一个类，实现 Runnable 接口,然后把实例关联到 Thread 上
/*
        Thread t = new Thread(new MyRunnable());
        t.start();
*/

       // 4、通过匿名内部类来实现 Runnable 接口
 /*       Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("我是一个新线程");

            }
        };
        Thread t = new Thread(runnable);
        t.start();
*/

        // 5、使用 lambda 表达式来指定要线程执行的内容
        Thread t = new Thread(() -> {
                System.out.println("我是一个新线程");
        });
        t.start();
    }
}
