

class Node{
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}

//单链表
public class MyLinedList {

    public Node head;//头

    public MyLinedList() {
        this.head = null;
    }

    //头插法
    public void addFist(int data){
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }
    //尾插法
    public void addList(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        if(this.head == null) {
            this.head = node;
            return;
        }
        while(cur.next!= null){
            cur = cur.next;
        }
        cur.next = node;
    }

    public void display() {
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void display2(Node newHead){
        Node cur = newHead;
        while(cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }


}
