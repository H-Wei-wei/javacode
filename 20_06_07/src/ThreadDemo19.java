import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 线程案例之线程池
 */

// runnable 本质上就是描述一段要执行的任务代码

public class ThreadDemo19 {

    // 用一个类来描述当前工作线程是啥样的
    static class Worker extends Thread{
        //每个 worker 线程都需要从任务线程中取任务
        //需要能获取到任务的实例
        BlockingQueue<Runnable> queue = null;
        int id = 0;
        public Worker(BlockingQueue<Runnable> queue, int id) {
            this.queue = queue;
            this.id = id;
        }

        @Override
        public void run() {
            // try 把 while 包含在内
            // 目的是线程收到异常，就结束 run 方法，即结束线程
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Runnable command = queue.take();
                    command.run();
                    System.out.println("Thread " + id + " running");
                }
            } catch (InterruptedException e) {
                // 线程被结束
                System.out.println("线程结束");
            }
        }
    }

    static class MyThreadPool {
        // 这个阻塞队列用来组织若干个任务
        private BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();
        // 用来组织若干个工作线程
        private List<Worker> workers = new ArrayList<>();
        // 根据实际情况来规定 maxWorkerCount
        private static final int maxWorkerCount = 10;
        // 实现核心方法
        public void execute(Runnable command) throws InterruptedException {
            // 延时加载的方法来创建线程
            // 当线程池中线程数目少时，新线程来作为工作线程
            // 当线程数目已经比较多时（达到设定阈值），就不用新建线程了

            if (queue.size() < maxWorkerCount) {
                Worker worker = new Worker(queue, queue.size());
                worker.start();
                workers.add(worker);
            }
            queue.put(command);
        }

        public void shutdown() throws InterruptedException {
            // 终止所有线程
            for (Worker worker: workers) {
                worker.interrupt();
            }
            // 等待每个线程结束（保证每个线程结束）
            for (Worker worker: workers) {
                worker.join();
            }
        }
    }

    static class Command implements Runnable {
        private int num;

        public Command(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            System.out.println("正在执行任务：" + num);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool();
        for (int i = 0; i < 1000; i++) {
            pool.execute(new Command(i));
        }
        Thread.sleep(2000);
        pool.shutdown();
        System.out.println("线程池已销毁");
    }
}
