import java.util.HashMap;
import java.util.Map;

public class Main {

    public int maxCandies (int[] candies, int[] coin, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < candies.length; i++) {
            sum += candies[i] * coin[i];
            if (coin[i] == 0) {
                map.put(candies[i], i);
            }
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            max = entry.getKey() > max ? entry.getKey() : max;
        }
        sum += max;
        return sum;
    }

    public static void main(String[] args) {

    }
}
