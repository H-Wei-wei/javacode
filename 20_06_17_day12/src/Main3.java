
public class Main3 {
    public static int addAB(int A, int B) {
        int a = 0;
        int b = 0;
        while (B != 0) {
            a = A ^ B;
            b = (A & B) << 1;
            A = a;
            B = b;
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(addAB(2, 3));
    }
}
