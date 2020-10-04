import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            Map<Character, Integer> map = new LinkedHashMap<>();
//            Set<Character> set = new LinkedHashSet<>();
//            String s = sc.next();
//            for (int i = 0; i < s.length(); i++) {
//                set.add(s.charAt(i));
//            }
//            for (char value: set) {
//                int count = 0;
//                for (int i = 0; i < s.length(); i++) {
//                    if (value == s.charAt(i) ) {
//                        count++;
//                    }
//                }
//                map.put(value,count);
//            }
//            int count = 1;
//            for (Map.Entry<Character,Integer> entry: map.entrySet()) {
//                System.out.print(entry.getKey() + "_" + entry.getValue());
//                if (count != map.size()) {
//                    System.out.print("_");
//                }
//                count++;
//            }
//        }
        while (sc.hasNext()) {
//            Map<Character, Integer> map = new HashMap<>();
            String s = sc.next();
            for (int i = 0; i < s.length();) {
                int count = 1;
                char c = s.charAt(i);
                int j = i + 1;
                for (; j < s.length(); j++) {
                    if (c == s.charAt(j)) {
                        count++;
                    }else {
                        System.out.print(c + "_"+ count);
//                        map.put(c, count);
                        System.out.print("_");
                        break;
                    }
                }
                if (j == s.length()) {
                    System.out.print(c + "_"+ count);
//                    map.put(c, count);
                }
                i = j;
            }
            System.out.println();
//            System.out.println(map);
//            int count = 1;
//            for (Map.Entry<Character,Integer> entry: map.entrySet()) {
//                System.out.print(entry.getKey() + "_" + entry.getValue());
//                if (count != map.size()) {
//                    System.out.print("_");
//                }
//                count++;
//            }
        }
    }
}
