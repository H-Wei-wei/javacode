import java.util.Arrays;
import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Main2 {
    public static ListNode partition(ListNode pHead, int x) {
        ListNode node = new ListNode(x);
        ListNode head = node;
        ListNode tail = node;
        ListNode prev = node;
        if (pHead == null) {
            return node;
        }
        ListNode cur = pHead;
        ListNode curNext = pHead.next;
        while (true) {
            if (cur.val < x) {
               cur.next = node;
               if (prev == node) {
                   head = cur;
               }else {
                  prev.next = cur;
               }
                prev = cur;
            }else {
                tail.next = cur;
                tail = cur;
                tail.next = null;
            }
            cur = curNext;
            if (cur.next == null) {
                break;
            }
            curNext = curNext.next;
        }
        prev.next = node.next;
        return head;
    }

}
