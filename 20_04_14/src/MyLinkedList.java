import java.util.LinkedList;

public class MyLinkedList {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        // 指定位置加入数据
        linkedList.add(0,"我");
        linkedList.add(1,"喜");
        linkedList.add(2,"欢");
        linkedList.add(3,"Java");
        System.out.println(linkedList);

        // 头插
        linkedList.addFirst("1");
        linkedList.addFirst("2");
        linkedList.addFirst("3");
        System.out.println(linkedList);

        // 尾插
        linkedList.addLast("它");
        linkedList.addLast("很");
        linkedList.addLast("好");
        System.out.println(linkedList);

        // get 获取指定位置下标
        System.out.println(linkedList.get(5));
        // getFirst 获取头位置元素
        System.out.println(linkedList.getFirst());
        // getLast 获取尾位置下标
        System.out.println(linkedList.getLast());
        // contains 是否包含该元素
        System.out.println(linkedList.contains("Java"));

        linkedList.add(1,"它");
        System.out.println(linkedList);

        // 返回最左侧第一个该元素的位置下标
        System.out.println(linkedList.indexOf("它"));
        // 返回最右侧第一个该元素的位置下标
        System.out.println(linkedList.lastIndexOf("它"));

        /*// 移除第一次出现该元素
        linkedList.remove("它");
        System.out.println(linkedList);*/
        // 移除所有的该元素
        linkedList.removeFirstOccurrence("它");
        System.out.println(linkedList);

        linkedList.clear();
        System.out.println(linkedList);
    }
}
