
/**
 * 2、阻塞队列 -- "生产者 —— 消费者的关系"
 * 是循环队列
 */

public class ThreadDemo17 {

    static class BlockingQueue {
        // 队列的实现可以基于数组也可以基于链表来实现
        private int[] array = new int[1000];
        private volatile int head = 0; // 第一个元素下标
        private volatile int tail = 0; // 最后一个元素下标

        // 当 head == tail 时，数组可能有零个元素，也有可能数组满了
        // 所以借用 size 记录元素个数
        private volatile int size = 0; // 一个读一个写，为了保证内存可见性 ，加 volatile

        // 阻塞队列不包含队列的取队首元素操作

        // 入队列
        private void put(int value) throws InterruptedException {
            // 加锁来保证线程安全
            synchronized (this) {
                // 当队列满的时候，发生阻塞
                while (size == array.length) {
                    wait();
                }
                array[tail] = value;
                tail++;
                if (tail == array.length) {
                    tail = 0;
                }
                size++;
                // 当队列空时，插入元素后，通知出队列
                notify();
            }
        }

        // 出队列
        private int take() throws InterruptedException {
            int ret = -1;
            synchronized (this) {
                // 当队列为空时。发生阻塞
                while (size == 0) {
                    wait();
                }
                ret = array[head];
                head++;
                if (head == array.length) {
                    head = 0;
                }
                size--;
                // 队列满后，当有元素出队列，通知入队列
                notify();
            }
            return ret;
        }
    }
        public static void main(String[] args) {
            BlockingQueue queue = new BlockingQueue();

            Thread produce = new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        try {
                            queue.put(i);
                            System.out.println("生产元素：" + i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            produce.start();

            Thread consumer = new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            int ret = queue.take();
                            System.out.println("消费元素：" + ret);
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            consumer.start();
        }
}
