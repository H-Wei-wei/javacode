import java.util.Arrays;

public class classSort {
    public static void bubbleSort(int[] array) {
        for(int bound = 0; bound < array.length;bound++) {
            for(int cur = array.length - 1; cur > bound; cur--) {
                if(array[cur - 1] > array[cur]) {
                    swap(array,cur - 1,cur);
                }
            }
        }
    }
    public static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = bound + 1; cur< array.length; cur++) {
                if (array[cur] < array[bound]) {
                    swap(array,cur,bound);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1,4,7,3,5,9,8,6};
        //bubbleSort(array);
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}
