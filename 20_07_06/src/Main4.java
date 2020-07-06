
import java.util.*;

public class Main4 {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int num = sc.nextInt();
            String[] split = s.split("\\\\");
            String file = split[split.length - 1];
            String result = file + " " + num;
            map.put(result, map.getOrDefault(result, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int count = 0;
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (count < 8) {
                String[] split = entry.getKey().split(" ");
                if (split[0].length() > 16) {
                    split[0] = split[0].substring(split[0].length() - 16);
                }
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
            count++;
        }
    }
}
