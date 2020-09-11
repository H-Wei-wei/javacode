import java.util.ArrayList;

class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        } }

public class TestDemo2 {

    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ArrayList<Integer> list = new ArrayList<>();
//        ArrayList<Integer> ret = new ArrayList<>();
//        ListNode cur = listNode;
//        while (cur != null) {
//            list.add(cur.val);
//            cur = cur.next;
//        }
//        int[] array = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            array[i] = list.get(i);
//        }
//        int left = 0;
//        int right = array.length - 1;
//        while (left < right) {
//            int tmp = array[left];
//            array[left] = array[right];
//            array[right] = tmp;
//            left++;
//            right--;
//        }
//        for (int i = 0; i < array.length; i++) {
//            ret.add(array[i]);
//        }
//        return ret;

        ListNode cur = listNode;
        if (cur != null) {
            printListFromTailToHead(cur.next);
            list.add(cur.val);
        }
        return list;
    }

}
