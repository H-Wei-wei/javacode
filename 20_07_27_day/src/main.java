import java.util.Arrays;

public class main {
    public static void insertSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int i = bound + 1; i < array.length; i++) {
                if (array[bound] > array[i]) {
                    swap(array, bound, i);
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {4,3,5,7,2,1,9,0,5};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
