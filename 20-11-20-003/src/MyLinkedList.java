class Node {
    String  val;
    Node prev;
    Node next;

    public Node(String val) {
        this.val = val;
    }
}
public class MyLinkedList {

    private Node head;
    private Node last;

    public boolean add(String e ) {
        Node node = new Node(e);
        if (head == null) {
            head = node;
            last = node;
        }else {
            last.next = node;
            last = node;
        }
        return true;
    }

    public void add(int index, String e) {
        if (index < 0 || index > size ()) {
            throw new IndexOutOfBoundsException("下标越界" + index);
        }


    }

    public int size() {
        Node cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return 0;
    }

}
