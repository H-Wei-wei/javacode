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
        Node node = new Node(e);
        if (head == null) {
            head = node; // index 一定是0
            last = node;
        }else if (index == 0) {
            // 头插
            node.next = head;
            head.prev = node;
            head = node;
        }else if (index == size()) {
            // 尾插
            node.prev = last;
            last.next = node;
            last = node;
        }else {
            Node prev = getPrevIndex(index);
            prev.next.prev = node;
            node.next = prev.next;
            node.prev = prev;
            prev.next = node;
        }
    }

    // 删除index位置的元素
    public String remove(int index) {
        checkIndex(index);
        String value = null;
        // 此时链表不为空
        if (size() == 1) {
            // 如果只有一个元素
            value = head.val;
            head = last = null;
        }else if (index == 0) {
            value = head.val;
            head = head.next;
            head.prev = null;
        }else if (index == size() - 1) {
            value = last.val;
            last = last.prev;
            last.next = null;
        }else {
            Node prev = getPrevIndex(index);
            Node removeNode = prev.next;
            removeNode.next.prev = prev;
            prev.next = removeNode.next;
            value = removeNode.val;
        }
        return value;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("下标越界" + index);
        }
    }

    // 删除第一次出现的e
    public boolean remove(String e) {
        Node cur = head;
        while (cur != null) {
            if (cur.val.equals(e)) {
                // 删除元素
                Node prev = cur.prev;
                Node next = cur.next;
                // 如果prev为空就是头删
                if (prev != null) {
                    prev.next = next;
                }else {
                    head = head.next;
                }
                // 如果next为空就是为尾删
                if(next != null) {
                    next.prev = prev;
                }else {
                    last = last.prev;
                }
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // 获取index位置的元素
    public String get (int index) {
        checkIndex(index);
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public String set(int index, String e) {
        checkIndex(index);
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        String oldValue = cur.val;
        cur.val = e;
        return oldValue;
    }

    public boolean contains(String e) {
        return indexOf(e) != -1;
    }

    public int indexOf(String e) {
        Node cur = head;
        for (int i = 0; i < size(); i++) {
            if (cur.val.equals(e)) {
                return i;
            }
            cur = cur.next;
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int lastIndexOf(String e) {
        Node cur = last;
        for (int i = size() - 1; i >= 0; i--) {
            if (cur.val.equals(e)) {
                return i;
            }
            cur = cur.prev;
        }
        return -1;
    }

    private Node getPrevIndex(int index) {
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        return prev;
    }



    public int size() {
        int size = 0;;
        Node cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

}
