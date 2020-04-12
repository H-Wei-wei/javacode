import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        // map < key, value >
        Map<String,String> map = new HashMap<>();
        // 1. isEmpty 判空 , size 键值对的个数
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        // 2、插入键值对
        map.put("及时雨","宋江");
        map.put("行者","ws");
        map.put("玉麒麟","卢俊义");
        map.put("智多星","吴用");
        map.put("入云龙","公孙胜");
        
        // 3、get 根据 key 来查找 value，若没有返回null
        System.out.println(map.get("及时雨"));
        // getOrDefault 根据 key 查找 value，如果 map 中没有 ，返回默认值
        System.out.println(map.getOrDefault("行者","武松"));
        
        // 4、contains 判断元素是否存在
        // containsKey 效率比较高 算数复杂度为 O(1) ，containsValve 效率较低  O(n)
        System.out.println(map.containsKey("行者"));
        System.out.println(map.containsValue("宋江"));
        
        // 5、遍历 map 的键值对  entry 意思是 “条目”
        // 一个 entry 对象 就是一个键值对
        for (Map.Entry<String,String> entry: map.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        System.out.println(map);

        // 6、清空map
        map.clear();
        System.out.println(map);
        System.out.println(map.isEmpty());
        System.out.println(map.size());
    }
}
