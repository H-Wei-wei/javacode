import java.util.Arrays;

/**
 * 希尔排序 / (谢尔排序 / shell排序)
 */

public class Sort2 {
    public static void shellSort(int[] array) {
        int gap = array.length/2;
        while(gap >= 1) {
            insertSortGap(array,gap);
            gap = gap/2;
        }
        // 当 gap = 1 时，进行一次插排
        //insertSortGap(array,1);
    }

    private static void insertSortGap(int[] array, int gap) {
        for(int bound = gap; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound - gap;
            for(;cur >= 0; cur -= gap) {
                if(array[cur] > tmp) {
                    array[cur + gap] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + gap] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,4,2,7,6,3,9,8,5};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }
}
