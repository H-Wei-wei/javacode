import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        // 1、实例化 list
        List<String> list = new ArrayList<>();
        // 2、list添加数据
        list.add("语文");
        list.add("数学");
        list.add("英语");
        list.add("物理");
        list.add("化学");
        // 3、打印 list
        System.out.println(list);
        // 4、根据下标获取 list 里的元素
        System.out.println(list.get(3));
        // 5、根据下标获取元素并重置该元素
        System.out.println(list.set(2,"生物"));
        System.out.println(list);
        System.out.println("===================");
        // 根据 list 重新构造一个
        ArrayList<String> arrayList = new ArrayList<String>(list);
        LinkedList<String> linkedList = new LinkedList<String>(list);
        System.out.println(arrayList);
        System.out.println(linkedList);
        System.out.println("=================");
        // 基于现有的 list 的引用进行强制类型转换（向下转型）
        ArrayList<String> arrayList1 = (ArrayList<String>)list;
        System.out.println(arrayList1);
        System.out.println("================");
        //  清空list
        list.clear();
        System.out.println(list);
    }
}
