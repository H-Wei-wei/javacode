/**
 * 链表实现队列
 */
public class MyQueueLinkedList {
    static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node head = null;
    public Node tail = null;

    // 入队列
    public void offer(Node node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    // 取队首元素
    public Integer peak() {
        if (head == null) {
            return null;
        }
        return head.val;
    }
    // 出队列
    public Integer poll() {
        if (head == null) {
            return null;
        }
        int ret = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return ret;
    }

    public static void main(String[] args) {
        MyQueueLinkedList queue = new MyQueueLinkedList();
        queue.offer(new Node(5));
        queue.offer(new Node(4));
        queue.offer(new Node(3));
        queue.offer(new Node(2));
        queue.offer(new Node(1));
        System.out.println(queue.peak());
        while (queue.head != null) {
            System.out.print(queue.poll() + " ");
        }
    }
}
