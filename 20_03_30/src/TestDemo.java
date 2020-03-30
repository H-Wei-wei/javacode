
public class TestDemo {

    /**
     * 测试双向链表
     * @param args
     */
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst(1);
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(3);
        doubleLinkedList.addFirst(4);
        doubleLinkedList.addFirst(5);
        doubleLinkedList.addLast(0);
        doubleLinkedList.display();
        System.out.println("链表长度为"+doubleLinkedList.size());

        System.out.println("======插入一个数======");
        doubleLinkedList.addIndex(2,8);
        doubleLinkedList.display();

        System.out.println("=====判断是否包含key====");
        System.out.println(doubleLinkedList.contains(9));


    }

    /**
     * 两个有序链表合成一个有序链表
     * @param headA
     * @param headB
     * @return
     */

    public static Node mergeTwoLists(Node headA,Node headB){
        Node newHead = new Node(-1);
        Node tmp = newHead;
        //两个单链表都不为空
        while(headA != null && headB !=null) {
            if(headA.data < headB.data) {
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            }else{
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        //其中一个为空
        if(headA == null) {
            tmp.next = headB;
        }
        if(headB == null) {
            tmp.next = headA;
        }
        return newHead.next;
    }

    public static void main1(String[] args) {
        MyLinedList myLinedList = new MyLinedList();
        myLinedList.addList(1);
        myLinedList.addList(2);
        myLinedList.addList(5);
        myLinedList.addList(6);
        myLinedList.addList(9);
        myLinedList.display();

        MyLinedList myLinedList2 = new MyLinedList();
        myLinedList2.addList(6);
        myLinedList2.addList(21);
        myLinedList2.addList(33);
        myLinedList2.addList(55);
        myLinedList2.display();

        Node ret = mergeTwoLists(myLinedList.head,myLinedList2.head);
        myLinedList.display2(ret);
    }
}
