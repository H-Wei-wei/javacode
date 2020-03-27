

class Node{
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}

//单链表
public class MyLinedList {
    public Node head;

    public MyLinedList() {
        this.head = null;
    }
    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }

    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        if(this.head == null) {
            this.head = node;
            return;
        }
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        //判断index的合法性
        if(index < 0 || index > size()) {
            return;
        }

        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == size()) {
            addLast(data);
            return;
        }

        Node node = new Node(data);

        Node prev = findIndex(index);

        node.next = prev.next ;
        prev.next = node;

    }
    //prev走index-1步
    private Node findIndex(int index){
        int count = 0;
        Node prev = this.head;
        while(count < index-1) {
            prev = prev.next;
            count++;
        }
        return prev;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        Node cur = this.head;
        while(cur != null) {
            if(cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        Node prev = this.head;
        Node cur = this.head.next;
        while(cur != null) {
            if(cur.data == key) {
                prev.next = cur.next;
                return;
            }
            cur = cur.next;
            prev = prev.next;
        }
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        Node prev = this.head;
        Node cur = this.head.next;
        while(cur != null) {
            if(cur.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            }
            if(cur.data != key) {
                cur = cur.next;
                prev = prev.next;
            }
        }
        if(this.head.data == key) {
            this.head = this.head.next;
        }
    }

    //得到单链表的长度
    public int size() {
        int count = 0;
        Node cur = this.head;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public void display() {
        Node cur = this.head;
        while(cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void display2(Node newHead) {
        Node cur = newHead;
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear() {
        Node prev = this.head;
        Node cur = this.head.next;
        while(cur != null) {
            prev.next = null;
            prev = cur;
            cur = cur.next;
        }
        this.head = null;
    }

    //反转单链表
    public Node reverseList() {
        Node cur = this.head;
        Node newHead = null;
        Node prev = null;
        while(cur != null) {
            Node curNext = cur.next;
            if(curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    public Node midNode() {
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node FindKthToTail(int k) {
        if(k <= 0 || k > size()) {
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        while (k-1 > 0) {
            fast = fast.next;
            k--;
        }
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
