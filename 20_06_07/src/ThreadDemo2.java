
public class ThreadDemo2 {

    public static long count = 100_0000_0000l;

    public static void main(String[] args) {
        serial();
        //concurrency();
    }

    private static void concurrency() {
        long begin = System.currentTimeMillis();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a++;
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                int b = 0;
                for (long i = 0; i < count; i++) {
                    b++;
                }
            }
        };
        t1.start();
        t2.start();
        try {
            // 线程等待
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println((end - begin) + "ms");
    }

    private static void serial() {
        long begin = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a++;
        }
        int b = 0;
         for (int i = 0; i < count; i++) {
             b++;
         }
        long end = System.currentTimeMillis();
        System.out.println((end - begin) + "ms");
    }
}
