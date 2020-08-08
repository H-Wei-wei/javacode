import java.util.LinkedList;
import java.util.Queue;

public class TestDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList();
        queue.offer(5);
        queue.offer(4);
        queue.offer(3);
        queue.offer(2);
        queue.offer(1);
        System.out.println(queue);
    }
}
