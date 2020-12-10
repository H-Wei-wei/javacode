public class Main {
    public static int addAB(int A, int B) {
       return Math.addExact(A, B);
    }

    public static void main(String[] args) {
        int n = 1;
        int m = 2;
        System.out.println(addAB(n, m));
    }
}
