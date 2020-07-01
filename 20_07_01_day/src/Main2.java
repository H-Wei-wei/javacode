
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int candidateNum = sc.nextInt();//候选人数
            String[] candidateName = new String[candidateNum];
            for (int i = 0; i < candidateNum; i++) {
                candidateName[i] = sc.next();
            }

            int voterNum = sc.nextInt();//投票人数
            String[] vote = new String[voterNum];
            for (int i = 0; i < voterNum; i++) {
                vote[i] = sc.next();
            }

            //用 Map 来保存候选人和投票结果
            int invalid = 0; // 无用票数
            Map<String, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < candidateNum; i++) {
                map.put(candidateName[i], 0);
            }
            for (int i = 0; i < voterNum; i++) {
                if (map.get(vote[i]) != null) {
                    map.put(vote[i], map.get(vote[i]) + 1);
                }else {
                    invalid++;
                }
            }

            for (Map.Entry<String, Integer> entry: map.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
            System.out.println("Invalid : " + invalid);
        }
    }
}
