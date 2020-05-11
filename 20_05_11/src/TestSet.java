import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        // 加入元素，add 加入多个相同元素，在 Set 中只有一份，作用：去重
        set.add("初一");
        set.add("初二");
        set.add("初三");
        set.add("初四");
        set.add("初五");

        // 看某元素是否在 Set 中存在
        System.out.println(set.contains("初一"));

        // 删除某元素
        set.remove("初一");
        System.out.println(set.contains("初一"));

        System.out.println(set);
        for (String s:set) {
            System.out.println(s);
        }

        // 用迭代器来遍历
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
