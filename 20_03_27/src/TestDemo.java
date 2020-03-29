

public class TestDemo {

    //构造两链表的交点
    public static void  creatCut(Node headA,Node headB) {
        headA.next = headB.next.next.next;
    }

    public static Node getIntersectionNode(Node headA,Node headB) {
        Node pL = headA;
        Node pS = headB;

        int lenA = 0;
        int lenB = 0;

        while(pL != null) {
            lenA++;
            pL = pL.next;
        }
        while(pS != null){
            lenB++;
            pS = pS.next;
        }

        pL = headA;
        pS = headB;
        int len = lenA-lenB;

        if(len < 0) {
            pL = headB;
            pS = headA;
            len = lenB - lenA;
        }
        //保证pL指向长的链表，pS指向短的链表
        //保证len为正

        while(len > 0) {
            pL = pL.next;
            len--;
        }

        while(pL != null && pS != null){
            if(pL == pS) {
                return pL;
            }
            pS = pS.next;
            pL = pL.next;
        }

        /*while (pL != pS){
            pS = pS.next;
            pL = pL.next;
        }
        if(pL == pS && pL != null) {
            return pL;
        }*/

        return null;
    }

    public static void main(String[] args) {
        MyLinedList myLinedList = new MyLinedList();
        myLinedList.addLast(1);
        myLinedList.addLast(2);
        myLinedList.addLast(3);
        myLinedList.addLast(4);
        myLinedList.addLast(5);
        myLinedList.display();

        System.out.println("===========环的入口点==========");
        myLinedList.creatCycle();
        System.out.println(myLinedList.detectCycle().data);

        /*myLinedList.creatCycle();
        System.out.println("环相交点"+myLinedList.meet().data);

        *//*myLinedList.creatCycle();*//*
        System.out.println("是否有环"+myLinedList.hasCycle());
*/
       /* MyLinedList myLinedList1 = new MyLinedList();
        myLinedList1.addLast(6);
        myLinedList1.addLast(7);
        myLinedList1.addLast(8);
        myLinedList1.addLast(9);
        myLinedList1.addLast(10);
        myLinedList1.addLast(11);
        myLinedList1.addLast(12);
        myLinedList1.addLast(13);
        myLinedList1.addLast(14);
        myLinedList1.display();

        System.out.println("=========相交链表==========");
        creatCut(myLinedList.head,myLinedList1.head);
        Node ret = getIntersectionNode(myLinedList.head,myLinedList1.head);
        System.out.println("交点的data："+ret.data);
        myLinedList.display();
        myLinedList1.display();*/

        /*myLinedList.addLast(4);
        myLinedList.addLast(5);*/


       /* System.out.println("=======反转=====");
        Node ret = myLinedList.reverseList();
        myLinedList.display2(ret);*/

        /*System.out.println("======中间值=====");
        Node ret2 = myLinedList.midNode();
        System.out.println(ret2.data);*/

        /*System.out.println("=====求倒数第k个节点的data=====");
        Node ret = myLinedList.FindKthToTail(2);
        System.out.println(ret.data);*/

        /*System.out.println("=====把小于key的值放到前边======");
        Node newHead = myLinedList.partition(4);
        myLinedList.display2(newHead);*/

       /* System.out.println("=====清除掉相等的数====");
        Node ret = myLinedList.deleteDuplication();
        myLinedList.display2(ret);*/
    }
}
