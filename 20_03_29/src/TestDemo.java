
public class TestDemo {
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
        System.out.println("是否有环"+myLinedList.hasCycle());*/


         /* System.out.println("=====清除掉相等的数====");
        Node ret = myLinedList.deleteDuplication();
        myLinedList.display2(ret);*/

    }
}
