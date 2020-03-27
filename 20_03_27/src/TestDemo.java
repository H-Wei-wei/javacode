

public class TestDemo {
    public static void main(String[] args) {
        MyLinedList myLinedList = new MyLinedList();
        myLinedList.addLast(1);
        myLinedList.addLast(2);
        myLinedList.addLast(3);
        myLinedList.addLast(4);
        myLinedList.addLast(5);
        myLinedList.display();

       /* System.out.println("=======反转=====");
        Node ret = myLinedList.reverseList();
        myLinedList.display2(ret);*/

        /*System.out.println("======中间值=====");
        Node ret2 = myLinedList.midNode();
        System.out.println(ret2.data);*/

        System.out.println("=====求倒数第key个节点的data=====");
        Node ret = myLinedList.FindKthToTail(2);
        System.out.println(ret.data);

    }
}
