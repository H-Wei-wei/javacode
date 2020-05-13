import java.util.*;

/**
 * 只出现一次的数据
 */

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class SetMapInterview {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int x: nums) {
            Integer count = map.get(x);
            if (count == null) {
                map.put(x,1);
            }else {
                map.put(x,count + 1);
            }
        }
        //System.out.println(map);
        // 遍历 Map
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }
        return 0;
    }
    public int singleNumber2(int[] nums) {
        int ret = 0;
        for (int x: nums) {
            ret = ret^x;
        }
        return ret;
    }

    // 有两个出现一次的数字
    public int[] singleNumber3(int[] nums) {
        int num = 0;
        for (int x: nums) {
            num = num^x;
        }
        int bit = 0;
        for (;bit < 32; bit++) {
            if ((num & (1 << bit)) > 0) {
                break;
            }
        }
       // bit 对应位是两个数异或结果的二进制数位为 1 的一个位置
        // 按照此位进行分组，bit位为 1 的为一组，为零的一组
        int a = 0;
        int b = 0;
        for (int x: nums) {
            if ((x & (1 << bit)) > 0) {
                a = a^x;
            }else {
                b = b^x;
            }
        }
        return new int[]{a, b};
    }

    public Node copyRandomList(Node head) {
        // Map<旧，新>
        Map<Node,Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur,new Node(cur.val));
        }
        for (Node cur = head; cur != null; cur = cur.next) {
            Node newcur = map.get(cur);
            newcur.next = map.get(cur.next);
            newcur.random = map.get(cur.random);
        }
        // 用旧链表的头去对应找新链表的头节点
        return map.get(head);
    }

    // 宝石与石头 J--宝石类型 ，S--石头
    public int numJewelsInStones(String J, String S) {
        int count = 0;

/*        // String.contains 的时间复杂度为 O(N),整体时间复杂度为 O(N^2)
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (J.contains(c + "")) {
                count++;
            }
        }
*/
        // Set.contains 的时间复杂度 小于 String.contains
        // 如果是 TreeSet.contains 时间复杂度为 O（logN）
        // 如果是 HashSet.contains 时间复杂度为 O(1)
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;

    }

    // 前 k 个高频单词
    public List<String> topKFrequent(String[] words, int k) {
        // 1.统计每个单词出现的次数
        Map<String,Integer> map = new HashMap<>();
        for (String x: words) {
            map.put(x,map.getOrDefault(x,0) + 1);
/*            Integer count = map.get(x);
            if (count == null) {
                map.put(x,1);
            }else {
                map.put(x,count + 1);
            }

*/          }
            // 2.去重
            List<String> list = new ArrayList<>(map.keySet());
            // 3.根据单词出现的次数 来对 list 排序，如果次数相等，就按字典序排序
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    // 匿名内部类 可以访问到上边的 map 变量
                    // 变量捕获
                    int count1 = map.get(o1);
                    int count2 = map.get(o2);
                    if (count1 == count2) {
                        return o1.compareTo(o2);
                    }
                    return count2 - count1;
                }
            });
            // 根据 K 这个元素，取出前 K 个值
            return list.subList(0,k);
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,2,1};
        SetMapInterview setMapInterview = new SetMapInterview();
        int ret = setMapInterview.singleNumber2(array);
        System.out.println(ret);
    }
}
