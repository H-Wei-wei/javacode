/**
 * 各属性
 */
public class ThreadDemo5 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread("初一") {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程要结束了");
            }
        };
        // 这一属性，只要是线程创建完毕，就不会改变
        System.out.println(t.getName());
        System.out.println(t.getPriority());  // 优先级
        System.out.println(t.isDaemon());
        System.out.println(t.getId());
        //这些属性会随着线程的运行过程发生改变
        System.out.println(t.isAlive());  // 线程还没开始start
        System.out.println(t.isInterrupted()); // 是否中断
        System.out.println(t.getState()); // new状态

        t.start();

        while (t.isAlive()) {
            System.out.println("线程正在运行");
            System.out.println(t.getState());
            System.out.println(t.isInterrupted());
            System.out.println(t.isAlive());
            Thread.sleep(300);
        }
    }
}
