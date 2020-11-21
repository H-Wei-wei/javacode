import java.util.ArrayList;
import java.util.List;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class TestDemo {
    public int  binarySearch(int[] array, int val) {
        int left = 0;
        int right = array.length;
        while (left < right) {
            int mid = (left + right)/2;
            if (array[mid] == val) {
                return mid;
            }else if (array[mid] < val) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return -1;
    }

    public Node HeBingList (Node[] heads) {
        List<Node> headList = arrayToList(heads);
        if (headList.isEmpty()) {
            return null;
        }
        Node newHead = new Node(-1);
        Node cur = newHead;
        while (headList.size() >= 2) {
            int index = -1; //这一次比较中值最小节点的下标
            for (int i = 0; i < headList.size(); i++) {
                Node head = headList.get(i);
                if (index == -1 || head.val < headList.get(index).val) {
                    index = i;
                }
            }
            Node rmNode = headList.remove(index);
            if (rmNode.next != null) {
                headList.add(rmNode.next);
            }
            cur.next = rmNode;
            cur = cur.next;
        }
        cur.next = headList.get(0);
        return newHead.next;
    }

    private List<Node> arrayToList(Node[] heads) {
        List<Node> list = new ArrayList<>();
        for (Node head: heads) {
            if (head != null) {
                list.add(head);
            }
        }
        return list;
    }

    // 汉诺塔     参数(柱子[0, n]，从from位置移动，到to位置)
    public static void hanoi(int n, int from, int to) {
        if (n < 1) {
            throw new IllegalArgumentException("n必须大于1, n=" + n );
        }
        if(n == 1) {
            System.out.println(from + " -> " + to);
            return;
        }
        int other = (0 + 1 + 2) - from - to;// 找出中间空出的柱子
        hanoi(n - 1, from, other);
        System.out.println(from + " -> " + to);
        hanoi(n - 1, other, to);
    }

    public static void main(String[] args) {
        hanoi(3, 0, 2);
    }
}

