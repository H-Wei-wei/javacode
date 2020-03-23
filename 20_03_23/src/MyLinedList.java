

//节点类
class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
//单链表
public class MyLinedList {

    public Node head;

    public MyLinedList() {
        this.head = null;
    }

    //头插法   O(1)
    public void addFirst(int data){
        Node node = new Node(data);
        if(this.head == null) {
            //第一次插入节点
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }
    //尾插法  O(n)
    public void addLast(int data){
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
            return;
        }
        Node cur = head.next;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if(index < 0 || index > size()) {
            throw new RuntimeException("index位置不合法");
        }else if(index == 0) {
            addFirst(data);
        } else if(index == size()){
            addLast(data);
        }else {
            Node node = new Node(data);
            Node prev = findIndex(index);
            node.next = prev.next;
            prev.next = node;
        }
    }
    private Node findIndex(int index) {
        int count = 0;
        Node cur = this.head;
        while(count < index-1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
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
    public void remove(int key){
        if(this.head.data == key) {
            this.head = head.next;
        }
        Node prev = this.head;
        Node cur = prev.next;
        if(cur.data == key) {
            prev.next = cur.next;
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        Node prev = this.head;
        Node cur = this.head.next;
        while(cur != null) {
            if(cur.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            }else {
                cur = cur.next;
                prev = prev.next;
            }
            if(this.head.data == key) {
                this.head = this.head.next;
            }
        }
    }
    //得到单链表的长度
    public int size(){
        int count = 0;
        Node cur = this.head;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public void display(){
        Node cur = this.head;
        while(cur != null) {
            System.out.println(cur.data+" ");
            cur = cur.next;
        }
    }
    public void clear(){
        Node prev = this.head;
        Node cur = this.head.next;
        while(cur != null) {
            prev.next = null;
            prev = cur;
            cur = cur.next;
        }
        this.head = null;
    }

}
