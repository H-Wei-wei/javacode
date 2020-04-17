
/**
 * 用链表实现队列
 */

public class MyQueue {
    // 用链表的头部表示队列的队首(便于删除)，尾部表示队尾（便于插入数据）
    static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    //  定义一个傀儡节点
    Node node = new Node(-1);
    Node tail = node;
    private int size = 0;

    // 计算队列中元素个数
    private int size() {
        Node cur = node.next;
        while(cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    // 入队
    private void offer(int value) {
        Node newNode = new Node(value);
        tail.next = newNode;
        tail = newNode;
    }

    // 出队（删除队首）
    private Integer poll() {
        Node toDelete = node.next;
        if(node.next == null) {
            return null;
        }
        node.next = toDelete.next;
        return toDelete.val;
    }

    // 取队首元素
    private Integer peak() {
        if (node.next == null) {
            return null;
        }
        return node.next.val;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);

        System.out.println("队列大小："+myQueue.size());
        System.out.println("队首元素："+myQueue.peak());

        while (true) {
            Integer cur = myQueue.poll();
            if (cur == null) {
                break;
            }
            System.out.println(cur);
        }
    }


}
