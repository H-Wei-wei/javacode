import java.util.ArrayList;
import java.util.Scanner;

 class ListNode {
   int val;
   ListNode next = null;
 }

public class Main {

//    public ArrayList<Integer> sort (int[] students){
//        for (int i = 0; i < students.length; i++) {
//
//        }
//    }

//    public static int getABA (int number) {
//        int n = func(number);
//        int n1 = 0;
//        int n2 = 0;
//        int x1 = 0;
//        int x2 = 0;
//        while (true) {
//            number++;
//            String s = number + "";
//            n1++;
//            if (s.charAt(0) == s.charAt(s.length() - 1)) {
//                x1 = Integer.valueOf(s);
//                System.out.println( "x1:" + x1);
//                break;
//            }
//            if (number >= 100000000) {
//                break;
//            }
//        }
//        number = number - n1;
//        while (true) {
//            number--;
//            String s = number + "";
//            n2++;
//            if (s.charAt(0) == s.charAt(s.length() - 1)) {
//                if(s.length() > 2) {
//                    if (s.charAt(0) == s.charAt(1)) {
//                        continue;
//                    }
//                }
//                x2 = Integer.valueOf(s);
//                System.out.println("x2:"+x2);
//                break;
//            }
//            if (number <= 0) {
//                break;
//            }
//        }
//        int ret = (n1 > n2 ? x2 : x1);
//        if (n1 == n2 && x2 != 0) {
//            ret = x2;
//        }
//        if (n1 == 0 && n2 != 0) {
//            return x2;
//        }
//        if (n1 != 0 && n2 == 0) {
//            return x1;
//        }
//        return ret;
//    }
//
//    private static int func(int number) {
//        int count = 0;
//        while (number >= 10) {
//            number = number/10;
//            count++;
//        }
//        return count;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int n = sc.nextInt();
//            System.out.println("out:"+getABA(n));
//        }
//    }

    public static ListNode solution (ListNode head, int m, int n) {
        ListNode cur = head;
        int size = 0;
        while (cur.next != null) {
            cur = cur.next;
            size++;
        }
        int[] array = new int[size];
        ListNode cur1 = head;
        for (int i = 0; i < size; i++) {
            array[i] = cur1.val;
            cur1 = cur1.next;
        }
        String s = "";
        for (int i = m - 1; i < n; i++) {
            s += array[i];
        }
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        for (int i = 0; i < sb.length(); i++) {
            array[m - 1] = Integer.valueOf(sb.charAt(i) + "");
             m++;
        }
        ListNode ret = head;
        while (cur.next != null) {
            int i = 0;
            cur.val = array[i];
            cur = cur.next;
            i++;
        }
        return ret;
    }

}
