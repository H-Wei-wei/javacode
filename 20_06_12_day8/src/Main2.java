import java.util.Arrays;

public class Main2 {

    public static int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int fac = 1;
        for (int i = 0; i < A.length; i++) {
            fac = 1;
            for (int j = 0; j < A.length; j++) {
                if (j != i) {
                    fac = A[j] * fac;
                }
            }
            B[i] = fac;
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        System.out.println(Arrays.toString(multiply(A)));
    }
}
