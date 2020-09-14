import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String strs = sc.nextLine();
            char[] chars = strs.toCharArray();
            int count = 0;
            List<ArrayList<Character>> list = new ArrayList<>();
            for (int i = 0; i < chars.length; i++) {
                count = 0;
                List<Character> inputList = new ArrayList<>();
                for (int j = i; j < chars.length; j++) {
                    if (chars[j] >= '5' && chars[j] <= '8') {
                        inputList.add(chars[j]);
                    } else {
                        break;
                    }
                }
                list.add((ArrayList<Character>) inputList);
            }
            Map<ArrayList<Character>, Integer> outputMap = new HashMap<>();
            int max = 0;
            int bound = 0;
            String[] str = new String[1];
            for (ArrayList l : list) {
                if (l.size() > max) {
                    max = l.size();
                    outputMap.put(l, l.size());
                }
            }
            for (Map.Entry m : outputMap.entrySet()) {
                String ch = m.getKey().toString();
                if (max == (int) m.getValue()) {
                    char[] chs = ch.toCharArray();
                    int len = chs.length;
                    for (int cur = 0; cur < len; cur++) {
                        System.out.print(chs[cur]);
                    }
                }
            }
        }
    }
}
