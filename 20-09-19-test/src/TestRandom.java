import java.util.Random;

public class TestRandom {
    public static void main(String[] args) {
        int i = 10;
        Random r = new Random(1);
        while (i-- > 0) {
            int n = r.nextInt();
            System.out.println(n);
        }
    }
}
