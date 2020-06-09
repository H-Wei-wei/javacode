/**
 * 中断
 * 1、借助一个标志位
 * 结束方式比较温和，当此次循环完了后，才结束线程
 */
public class ThreadDemo6 {
    private static boolean isQuit = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (!isQuit) {
                    System.out.println("别烦我，我在转账");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("转账被终止");
            }
        };
        t.start();

        Thread.sleep(5000);
        // 终止交易
        System.out.println("有内鬼，赶快停止交易");
        isQuit = true;
    }
}
