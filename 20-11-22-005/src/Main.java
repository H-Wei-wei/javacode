import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void hanoi(int n, int from, int to) {
        if (n < 1) {
            throw new IllegalArgumentException("n必须大于一");
        }
        if (n == 1) {
            System.out.print( from + "->" + to + " ");
            System.out.println();
            return;
        }
        int other = (0 + 1 + 2) - from - to;
        hanoi(n - 1, from, other);
        System.out.print(from + "->" + to + " ");
        hanoi(n - 1, other, to);
    }

    public static void main(String[] args) {
        hanoi(3, 0, 2);
    }

}
