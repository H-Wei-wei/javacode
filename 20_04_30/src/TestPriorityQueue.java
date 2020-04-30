import java.util.Comparator;
import java.util.PriorityQueue;

// 库中优先队列里的堆，默认是小堆
public class TestPriorityQueue {

    static class MyComp implements Comparator<Integer> {
        // 重写比较方法
        @Override
        public int compare(Integer o1, Integer o2) {
           return o2 - o1;
       }
   }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new MyComp());
        queue.offer(2);
        queue.offer(3);
        queue.offer(7);
        queue.offer(8);
        queue.offer(1);
        queue.offer(9);

        while(!queue.isEmpty()) {
            System.out.print(queue.poll()+" ");
        }
    }

}
