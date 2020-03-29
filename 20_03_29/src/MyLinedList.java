
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
    public void display() {
        Node cur = this.head;
        while(cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    //以给定值x为基准将链表分割成两部分，
    // 所有小于x的结点排在大于或等于x的结点之前
    public Node partition (int x) {
        Node bs = null;
        Node be = null;
        Node as = null;
        Node ae = null;
        Node cur = this.head;
        while (cur != null) {
            if(cur.data < x) {
                if (bs == null) {
                    bs = cur;
                    be = bs;
                } else {
                    be.next = cur;
                    be = be.next;
                }
            }else {
                if(as == null) {
                    as = cur;
                    ae = as;
                }else{
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        //假设第一段没有数据
        if(bs == null) {
            //返回第二段数据
            return as;
        }
        //bs != null
        be.next = as;
        //只要第二段 不为空
        if(as != null) {
            ae.next = null;
        }
        return bs;
    }

    //删除有相等的数据的数
    public Node deleteDuplication() {
        Node node = new Node(-1);
        Node cur = this.head;
        Node tmp = node;
        while(cur != null) {
            if(cur.next != null && cur.data == cur.next.data) {
                while(cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;
            }else{
                tmp.next = cur;
                tmp = cur;
                cur = cur.next;
            }
        }
        tmp.next = null;
        return node.next;
    }

    //回文链表
    public boolean chkPalindrome(){
        Node fast = this.head;
        Node slow = this.head;
        //找中间节点
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //slow为中间节点
        //反转slow之后的链表
        Node cur = slow.next;
        while(cur != null) {
            Node curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //slow为最后一个节点
        while(slow != this.head){
            if(slow.data != this.head.data) {
                return false;
            }
            //偶数时的判断
            if(this.head.next == slow) {
                return true;
            }
            slow = slow.next;
            this.head = this.head.next;
        }
        return true;
    }

    //造环
    public void creatCycle(){
        Node cur = this.head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = this.head.next.next;
    }
    //判断是否有环
    public boolean hasCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return  false;
    }

    /**
     * 相遇点
     * @return
     */
    public Node meet(){
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return fast;
            }
        }
        return  null;
    }

    /**
     * 入口点
     * @return
     */
    public Node detectCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                slow = this.head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return  null;
    }
}
