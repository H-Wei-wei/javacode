
public class Main {
    public static int getValue(int[] gifts, int n) {
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (gifts[i] == gifts[j]) {
                    count++;
                }
            }
            if (count > n/2) {
                return gifts[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(getValue(new int[]{1, 2, 3, 3, 3, 6}, 6));
    }
}
