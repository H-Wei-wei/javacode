import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                Integer value = map.get(s.charAt(i));
                if (value == null) {
                    map.put(s.charAt(i), 1);
                }else {
                    map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
                }
                //map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
            }
            for (Map.Entry<Character,Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
    }
}
