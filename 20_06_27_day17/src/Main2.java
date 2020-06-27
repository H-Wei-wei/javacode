
import java.util.*;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Main2 {
    public ListNode plusAB(ListNode a, ListNode b) {
        if (a == null && b == null) {
            return null;
        }
        if (b == null) {
            return a;
        }
        if (a == null) {
            return b;
        }
        ListNode head = new ListNode(0);// 傀儡节点
        ListNode cur = head;
        int num = 0; // 位上的和
        int carry = 0;// 进位
        while (a.next != null || b.next != null || carry!= 0) {
            num = a.val + b.val;
            int tmp = num % 10 + carry;
            cur.next = new ListNode(tmp);
            carry = num / 10;
            a = a.next;
            b = b.next;
            cur = cur.next;
        }
        return head.next;
    }
}