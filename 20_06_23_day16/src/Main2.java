
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Main2 {
    public ListNode partition(ListNode pHead, int x) {
        ListNode node = new ListNode(x);
        ListNode cur = pHead;
        ListNode prev = null;
        if (pHead == null) {
            return node;
        }
        while (cur != null) {
            if (x <=cur.val) {
                node.next = pHead;
                pHead = node;
                prev = cur;
                cur = cur.next;
            }else {
                prev.next = cur.next;
                cur.next = pHead;
                pHead = cur;
                cur = prev.next;
                
            }

        }

    }
}
