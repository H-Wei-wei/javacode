
public class ThreadDemo8 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("我是线程1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("我是线程2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        /*t1.start();
        t1.join();//等待线程1结束

        t2.start();
        t2.join();// 等待线程2结束*/

        t1.start();
        t2.start();
        t1.join();// 等待线程结束，最后执行主线程
        t2.join();

        System.out.println("结束");
    }
}
