import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = "";
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 10 ; i++) {
               int n = sc.nextInt();
                for (int j = 0; j < n; j++) {
                    list.add(i);
                }
            }
            Collections.sort(list);
            for (int i = 0; i < list.size() ; i++) {
                if (list.get(i) != 0) {
                    s += list.get(i);
                    list.remove(i);
                    break;
                }
            }
            for (int i = 0; i < list.size(); i++) {
                s += list.get(i);
            }
            System.out.println(s);
        }
    }
}
