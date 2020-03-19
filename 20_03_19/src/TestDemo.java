import java.util.Arrays;
import java.util.Scanner;

public class TestDemo {

    /**
     * 数组逆序
     * @param args
     */
    public static void reverse (int[] array) {
        int left = 0;
        int right = array.length - 1;
        while(left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        reverse(array);
        System.out.println(Arrays.toString(array));
    }

    public static void main10(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        //二分法查找
        System.out.println(Arrays.binarySearch(array,6));
        //打印数组
        System.out.println(Arrays.toString(array));
        //拷贝数组
        int[] arr1 = Arrays.copyOf(array,array.length);
        System.out.println(Arrays.toString(arr1));
        //拷贝部分数组
        int[] arr2 = Arrays.copyOfRange(array,3,5);
        System.out.println(Arrays.toString(arr1));
    }

    public static void main9(String[] args) {
        int[][] array1 = new int[2][3];
        int[][] array2 = new int[][]{{1,2,3},{4,5,6}};
        array1[0] = new int[]{1,2,3,4,5};
        array1[1] = new int[]{1,2,3};
        System.out.println(Arrays.deepToString(array1));
    }

    /**
     * 实现一个方法toString
     * @param array
     * @return
     */
    public static String toString(int[] array) {
        String ret = "[";
        for(int i = 0; i < array.length; i++) {
            ret += array[i];
            if(i != array.length-1) {
                ret += ",";
            }
        }
      ret += "]";
        return ret;
    }
    public static void main8(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(toString(array));
    }

    /**
     * 实现方法copyOf拷贝一个数组
     * @param ret
     * @param array
     */
    public static void copyOf(int[] ret,int[] array) {
        for(int i = 0; i < array.length; i++) {
            ret[i] = array[i];
        }
    }
    public static void main7(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        //int[] ret = Arrays.copyOf(array,array.length);
        int[] ret = new int[array.length];
        copyOf(ret,array);
        System.out.println(Arrays.toString(ret));
    }

    /**
     * 对有序整形数组，进行二分法查找
     * @param array
     * @param n
     * @return
     */
    public static int binarySearch(int[] array,int n) {
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] < n) {
                left = mid + 1;
            }else if(array[mid] > n) {
                right = mid - 1;
            }else{
                return left;
            }
        }
        return -1;
    }
    public static void main6(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入要查找的的数：");
        int n = scan.nextInt();
        System.out.println("要查找的数在数组中的下标："+binarySearch(array,n));
    }

    /**
     * 判断数组是否有序
     * @param array
     * @return
     */
    public static boolean isSorted(int[] array) {
        boolean flg = false;
        for (int i = 0; i < array.length-1; i++) {
            if(array[i] > array[i + 1]) {
                    return false;
            }
        }
        return true;
    }
    public static void main5(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(isSorted(array));
        //System.out.println(Arrays.toString(array));
    }

    /**
     * 冒泡排序
     * @param array
     */
    public static void bubbleSort(int[] array) {
        boolean  flg = false;
        for (int j = 0; j < array.length - 1 - j; j++) {
            flg = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    flg = true;
                }
                if(flg == false) {
                     return;
                }
            }
        }
    }
    public static void main4(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void main3(String[] args) {
        //不规则数组
        int[][] array = new int[2][];
        array[0] = new int[]{1,2,3,4,5};
        array[1] = new int[]{1,2,3,4};
        System.out.println(Arrays.deepToString(array));
    }

    public static void main2(String[] args) {
        //规则数组
        int[][] array1 = new int[2][3];
        int[][] array2 = new int[][]{{1,2},{3,4},{5,5}};
        int[][] array3 = new int[][]{{1,2,3},{4,5,6}};

        for (int i = 0; i < array3.length; i++) {
            for (int j = 0; j < array3[i].length; j++) {
                System.out.print(array3[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(Arrays.deepToString(array3));
    }

    public static void swap(int[] array) {
       int left = 0;
       int right = array.length - 1;
        while(left < right) {
            while(left < right && array[left] % 2 == 0 ) {
                //偶数
                left++;
            }
            //left的下标为奇数
            while(left < right && array[right] % 2 != 0 ) {
               //奇数
                right--;
            }
            //right下标的数是偶数
            //交换奇数和偶数
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
        }
    }
    public static void main1(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        swap(array);//偶数在前奇数在后
        System.out.println(Arrays.toString(array));
    }
}
