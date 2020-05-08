import java.util.Arrays;

public class Sort {
    // 快速排序
    public static void quickSort(int[] array) {
        // 先创建一个辅助递归的方法
        quickSortHelper(array,0,array.length-1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        // 基准值位置下标
        int index = partition(array,left,right);
        // [left, index-1]
        quickSortHelper(array,left,index - 1);
        // [index+1,right]
        quickSortHelper(array,index+1,right);
    }

    private static int partition(int[] array, int left, int right) {
        // 以最后一个元素为基准值
        int value = array[right];
        int i = left;
        int j = right;
        while (i < j) {
            // 从左边找,找比基准值大的元素
            while(i < j && array[i] <= value) {
                i++;
            }
            //左边找到了比基准值大的元素
            // 从右边找，找比基准值小的元素
            while (i < j && array[j] >= value) {
                j--;
            }
            //右边找到了小于基准值的元素
            // 交换 i 和 j 的元素
            swap(array,i,j);
        }
        // left 和 right 重合
        // 交换 left ，和基准值的位置
        swap(array,i,right);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {5,3,7,9,1,2,4,8,6};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
