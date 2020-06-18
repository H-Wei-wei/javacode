import java.util.concurrent.PriorityBlockingQueue;

public class ThreadDemo18 {
    // 优先队列中的元素必须是可以比较的
    // 比较规则两种方式：
    // 1、让 Task 实现 Comparable 接口
    // 2、让优先队列构造的时候，传入一个比较器对象（comparator）
    static class Task implements Comparable<Task>{
        private Runnable command;
        // time 表示啥时间来执行 command，是一个绝对时间
        private long time;

        // 构造方法表示：多少毫秒之后执行。（相对时间）
        public Task(Runnable command, long after) {
            this.command = command;
            this.time = System.currentTimeMillis() + after;
        }

        // 执行任务的具体逻辑
        public void run() {
            command.run();
        }

        @Override
        public int compareTo(Task o) {
            // 谁的时间小谁先执行
            return (int) (this.time - o.time);
        }
    }

    static class Worker extends Thread {
        private PriorityBlockingQueue<Task> queue = null;
        private Object mailBox = null;
        public Worker(PriorityBlockingQueue<Task> queue,Object o) {
            this.queue = queue;
            this.mailBox = o;
        }

        @Override
        public void run() {
            // 实现具体的线程执行的内容
            while (true) {
                try {
                    //1、取出队首元素
                    Task task = queue.take();
                    // 2、检查当前任务时间是否到了
                    long curTime = System.currentTimeMillis();
                    if (task.time > curTime) {
                        // 时间还没到，就把任务放回队列中
                        queue.put(task);
                        synchronized (mailBox) {
                            mailBox.wait(task.time - curTime);
                        }
                    }else {
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
    static class Timer {
        // 为了避免忙等，需要使用 Wait 方法
        //使用一个单独的对象来辅助进行wait
        // 使用 this 也可以
        private Object mailBox = new Object();

        // 1.需要先构造一个类，来描述任务
        // 2、用阻塞队列来组织若干个队列，让队首元素最先执行，如果队首元素时间未到
        //      其他元素也不能执行
        private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
        // 3、用一个线程来循环扫描当前队列中的队首元素,如果时间到就执行当前任务
        public Timer() {
            // 创建线程
            Worker worker = new Worker(queue,mailBox);
            worker.start();
        }
        // 4、还需要提供一个方法，让调用者把任务安排进来
        //    schedule => 安排
        public void schedule(Runnable command, long after) {
            Task task = new Task(command, after);
            queue.put(task);
            synchronized (mailBox) {
                mailBox.notify();
            }
        }

        public static void main(String[] args) {
            Timer timer = new Timer();
            timer.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hehe");
                    timer.schedule(this,2000);
                }
            }, 2000);
        }
    }
}
