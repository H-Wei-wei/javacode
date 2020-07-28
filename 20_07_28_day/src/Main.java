import java.util.Arrays;

public class Main {
    // 冒泡排序
    public static void bubbleSort (int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = 0; cur < array.length - 1 - bound; cur++) {
                if (array[cur] > array[cur + 1]) {
                    int tmp = array[cur];
                    array[cur] = array[cur + 1];
                    array[cur + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {3,5,2,7,9,4,7,6,1,0};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
