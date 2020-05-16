import java.util.Arrays;

public class MyHashMap {
    static class Node {
        public int key;
        public int value;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    // 给定数组
    public Node[] array = new Node[100];
    // 数组中的元素个数
    public int size = 0;

    // 负载因子 = size / array.length

    // 插入元素
    public void put(int key, int value) {
        // 1.根据 key 代入 hash 函数中，得到数组下表
        int index = hashFunc(key);
        // 2.根据下表得到对应链表
        Node head = array[index];
        // 3.先判断 key 是否存在。如果存在就修改 value 值（不插入新节点）
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.key == key) {
                cur.value = value;
                return;
            }
        }
        // 4.如果不存在就插入新节点，（链表头插）
        Node newNode = new Node(key,value);
        newNode.next = head;
        array[index] = newNode;

    }

    private int hashFunc(int key) {
        return key % array.length;
    }

    // 查找
    public Integer get(int key) {
        // 根据 key 找到 hash 值
        int index = hashFunc(key);
        // 在对应的链表上查找指定的 key 对应的节点
        Node head = array[index];
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.key == key) {
                return cur.value;
            }
        }
        // 没找到
        return null;
    }

    public void remove(int key) {
        // 根据 key 找到 hash 值
        int index = hashFunc(key);
        // 在对应的链表上查找指定的 key 对应的节点
        Node head = array[index];
        // 如果头结点是要删除的节点
        if (head.key == key) {
            array[index] = head.next;
            return;
        }
        // 如果删除的不是头结点
        Node prev = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.key == key) {
                prev.next = cur.next;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
        // 没有要删除节点
        return;
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1,10);
        myHashMap.put(3,30);
        myHashMap.put(2,20);
        myHashMap.put(7,70);
        myHashMap.put(107,1070);


        System.out.println(Arrays.toString(myHashMap.array));

        //System.out.println(myHashMap.get(107));
        myHashMap.remove(107);
        System.out.println(Arrays.toString(myHashMap.array));


    }

}
