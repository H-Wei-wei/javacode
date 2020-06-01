
/**
 * 数组中的逆序对
 */
public class TestDemo {

    public static int count(int[] A, int n) {
        int num = 0;
        for (int bound = 0; bound < n; bound++) {
            for (int cur = bound + 1; cur < n; cur++ ) {
                if (A[bound] > A[cur]) {
                    num++;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,10,9};
        System.out.println(count(array, array.length));
    }
}
