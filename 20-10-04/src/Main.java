
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}

public class Main {
    public static ListNode head;
    public static void addNode(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
            return;
        }
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode nHead = new ListNode(-1);
        nHead.next = head;
        ListNode bound = head;
        ListNode prev = head;
        ListNode cur = prev.next;
        while (bound != null) {
            while (cur != null) {
                if (cur.next != null && cur.val == bound.val) {
                    while (cur.next != null && cur.val == bound.val) {
                        cur = cur.next;
                    }
                    cur = cur.next;
                }else {
                    prev.next = cur;
                    prev = cur;
                    cur = cur.next;
                }
            }
            bound = bound.next;
        }
        prev.next = null;
        return nHead.next;
    }

    public static ListNode deleteDuplication() {
        ListNode node = new ListNode(-1);
        ListNode cur = head;
        ListNode tmp = node;
        while(cur != null) {
            if(cur.next != null && cur.val == cur.next.val) {
                while(cur.next != null && cur.val == cur.next.val) {
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

    public static void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
    public static void main(String[] args) {
        addNode(1);
        addNode(4);
        addNode(2);
        addNode(4);
        addNode(5);
        addNode(4);
        addNode(4);
        print(head);
        System.out.println();
        deleteDuplication();
        print(head);
//        ListNode newHead = deleteDuplicates(head);
//        print(newHead);
    }
}
