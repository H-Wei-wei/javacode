/**
 * 命名
 */
public class ThreadDemo4 {
    public static void main(String[] args) {
        Thread t = new Thread("hello,我是一个新线程") {
            @Override
            public void run() {
                while (true) {

                }
            }
        };
        t.start();
    }
}
