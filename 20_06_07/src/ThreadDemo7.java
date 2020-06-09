/**
 * 中断
 * 2、isInterrupted
 * 结束方式比较激进
 */
public class ThreadDemo7 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run()  {
                // 直接使用线程内部的标记位来判断
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("我在转账中");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        t.start();

        Thread.sleep(5000);
        System.out.println("对方是内鬼，停止交易");
        t.interrupt();
    }
}
