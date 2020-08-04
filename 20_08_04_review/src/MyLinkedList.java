
// 节点类
class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class MyLinkedList {
    public Node head;

    public MyLinkedList() {
        this.head = null;
    }

    //头插法
   public void addFirst(int data){
       Node node = new Node(data);
       if(head == null) {
           this.head = node;
           return;
       }
       node.next = this.head;
       this.head = node;
   }
    //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            return;
        }
        Node cur = head.next;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if (index < 0 || index > size()) {
            System.out.println("插入位置不合法");
        } else if(index == 0) {
            addFirst(data);
        } else if (index == size()) {
            addLast(data);
        }else {
            Node node = new Node(data);
            Node curNode = findIndex(index);
            node.next = curNode.next;
            curNode.next = node;
        }
    }
    private Node findIndex(int index) {
        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
       Node cur = head;
       while (cur != null) {
           if (cur.val == key) {
               return true;
           }
           cur = cur.next;
       }
       return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if (head.val == key) {
            head = head.next;
        }
        Node prev = head;
        Node cur = prev.next;
        while (cur != null) {
            if (cur.val == key) {
                prev.next = cur.next;
                break;
            }
            prev = cur;
            cur = prev.next;
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        if (head.val == key) {
            head = head.next;
        }
        Node prev = head;
        Node cur = prev.next;
        while (cur != null) {
            if (cur.val == key) {
                prev.next = cur.next;
            }
            prev = prev.next;
            cur = prev.next;
        }
    }
    //得到单链表的长度
    public int size(){
        int count = 0;
        Node cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    public void display(){
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
    public void clear(){
        Node prev = head;
        Node cur = prev.next;
        while (cur != null) {
            prev.next = null;
            cur = cur.next;
        }
        head = null;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addFirst(2);
        list.addFirst(5);
        list.addFirst(3);
        list.addFirst(8);
        list.addFirst(7);
        list.addFirst(9);
        list.addLast(1);
        list.display();
        System.out.println();
        System.out.println(list.size());
        list.addIndex(5, 7);
        list.addIndex(list.size(), 0);
        list.display();
        System.out.println();
        System.out.println(list.contains(1));
        list.remove(7);
        list.display();
        System.out.println();
        list.removeAllKey(7);
        list.display();
        System.out.println();
        list.clear();
        list.display();
    }
}
