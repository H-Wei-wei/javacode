import java.util.Arrays;

/**
 * 插入排序
 */

public class Sort {
    public static void interSort(int[] array) {
        // bound 表示要排序的元素的位置
        for(int bound = 1; bound < array.length; bound++) {
            // 将 count 位置元素存到一个内存中
            int tmp = array[bound];
            // [0, count)为有序区间
            // [count, size)为无序区间
            int cur = bound-1;
            // 循环遍历有序元素，比较其元素与count位置元素大小
            for(; cur >= 0; cur--) {
                if( array[cur] > tmp) {
                    // 将 cur 位置元素移到 bound 处
                    array[cur + 1] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,4,2,7,6,3,9,8,5};
        interSort(array);
        System.out.println(Arrays.toString(array));
    }
}
