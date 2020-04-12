import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class TestCollection {
    public static void main(String[] args) {
        // collection 中的 add ，remove，clear 等方法是抽象方法
        //这些方法在执行的时候，具体行为取决于 collection 对应真实对象的类型

        //collection 是一个接口，需要 new 一个对应的类作为实例来实现接口
        Collection<String> collection = new ArrayList<>();
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());

        //增
        collection.add("我");
        collection.add("喜");
        collection.add("欢");
        collection.add("你");

        System.out.println("============");
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());

        //将其转换成数组
        // toArray() 返回值是 Object 类型数组
        // String 也是继承 Object  array看似是 Object 类型的，实际上也是 String 类型的
        Object[] array = collection.toArray();
        //遍历数组
        for (Object i: array) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(Arrays.toString(array));
        System.out.println(collection);

        //是否包含某元素
        // contains 内部是拿参数的对象的值和集合中的对象的值比较的
        boolean flag = collection.contains("你");
        System.out.println(flag);

        //删除某一个元素
        collection.remove("你");
        System.out.println(collection);
        System.out.println(collection.size());

        //清空 collection
        collection.clear();
        System.out.println(collection);
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());

    }

}
