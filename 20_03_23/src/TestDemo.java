import sun.java2d.windows.GDIWindowSurfaceData;

public class TestDemo {
    public static void main(String[] args) {
        MyLinedList myLinedList = new MyLinedList();
        myLinedList.addFirst(1);
        myLinedList.addFirst(2);
        myLinedList.addFirst(2);
        myLinedList.addFirst(4);
        myLinedList.addLast(5);
        System.out.println("链表长度"+myLinedList.size());
        myLinedList.display();
        System.out.println("====判断key是否在链表内====");
        System.out.println(myLinedList.contains(7));
        System.out.println("====在index处添加data====");
        myLinedList.addIndex(3,6);
        myLinedList.display();
        /*System.out.println("======删掉第一次出现的key=====");
        myLinedList.remove(2);
        myLinedList.display();*/

        System.out.println("====删除所有的key====");
        myLinedList.removeAllKey(2);
        myLinedList.display();
        System.out.println("====clear===");
        myLinedList.clear();
        myLinedList.display();
    }
}
