import java.util.ArrayList;
import java.util.List;

class NodeN {
    int val;
    NodeN next;

    public NodeN(int val) {
        this.val = val;
    }
}

public class Interview {

    // 链表逆序
    public NodeN revise(NodeN head) {
        NodeN cur = head;
        NodeN prev = null;
        while (cur != null) {
            NodeN nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        return prev;
    }

    // 判断链表回文
    // 找出中心节点，后边进行逆序
    public boolean HuiWen(NodeN head) {
        NodeN cur = head;
        int mid = size(head)/2;
        for (int i = 0; i < mid; i++) {
            cur = cur.next;
        }
        NodeN cur1 = head;
        NodeN cur2 = revise(cur);// 后置逆序
        while (cur1 != null && cur2 != null) {
            if (cur1.val != cur2.val) {
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }

    private int size(NodeN head) {
        int size = 0;
        NodeN cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    // 两个有序链表合并成一个有序链表
    public NodeN HeBing(NodeN head1, NodeN head2) {
        NodeN cur1 = head1;
        NodeN cur2 = head2;

        NodeN newHead = new NodeN(-1);// 傀儡节点
        NodeN cur = newHead;

        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            }else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if (cur1 != null) {
           cur.next = cur1;
        }
        if (cur2 != null) {
            cur.next = cur2;
        }
        return newHead.next;
    }

    // 合并多个有序链表
    public NodeN HeBing(NodeN[] heads) {
        List<NodeN> headList = arrayToList(heads);
        if (headList.isEmpty()) {
            return null;
        }
        NodeN newHead = new NodeN(-1); // 傀儡节点
        NodeN cur = newHead;
        while (headList.size() >= 2) {
            int index = -1;
            for (int i = 0; i < headList.size(); i++) {
                NodeN head = headList.get(i);
                if (index == -1 || head.val < headList.get(index).val) {
                    index = i;
                }
            }
            // index 此时就是指向最小的第一个节点下标
            NodeN node = headList.remove(index);
            if (node.next != null) {
                headList.add(node.next);
            }
            cur.next = node;
            cur = node;
        }
        cur.next = headList.get(0);
        return newHead.next;
    }

    private List<NodeN> arrayToList(NodeN[] heads) {
        List<NodeN> list = new ArrayList<>();
        for (NodeN head: heads) {
            if (head != null) {
                list.add(head);
            }
        }
        return list;
    }

}
