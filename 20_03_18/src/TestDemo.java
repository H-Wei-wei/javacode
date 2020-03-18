import java.util.Arrays;
import java.util.Scanner;

public class TestDemo {

    //将一组有序数组逆序排列
    public static void reverse(int[] array) {
        int left = 0;
        int right = array.length-1;
        while(left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        reverse(array);
        System.out.println(Arrays.toString(array));
    }

    //冒泡排序
    public static void bubbleSort(int[] array) {
        boolean flg = false;
        for(int j = 0; j < array.length - 1; j++) {      //得排array.length-1趟
            flg = false; //可能中间又一次交换数据使其数组有序
            for (int i = 0; i < array.length - 1 - j; i++) {   //每一趟排序交换数的次序
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    flg = true;   //判断是否发生交换了
                }
            }
            if(flg == false) {    //没有发生交换后说明是有序的
                return;
            }
        }
    }
    public static void main11(String[] args) {
        int[] array = {1,3,2,4,5,63,33,21};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static boolean isSorted(int[] array) {
        for(int i = 0; i < array.length-1; i++) {
            if(array[i + 1] < array[i]) {
                return false;
            }
        }
        return true;
    }
    //判断一组数据是否有序
    public static void main10(String[] args) {
        int[] array = {1,2,3,44,5,6,7,8,9,10};
        System.out.println(isSorted(array));
    }

    public static void main9(String[] args) {
        int[] array1 = {1,2,3,4,5,6,7,8,9,10};
        int[] array2 = {1,2,3,4,5,6,7,8,9,10};
        //判断两数组是否相等----Arrays.equals
        System.out.println(Arrays.equals(array1, array2));
    }

    public static void main8(String[] args) {
        int[] array = new int[] {1,33,44,22,55,67,78,88};
        Arrays.sort(array); //对数组进行排序
        System.out.println(Arrays.toString(array));
       //System.out.println(binarySearch(array, 55));

        System.out.println(Arrays.binarySearch(array,5,7, 44));
    }

    public static int binarySearch(int[] array, int n) {
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int mid = (right + left)/2;
            if (n < array [mid]) {
                right = mid - 1;
            } else if (n > array[mid]) {
                left = mid + 1;
            } else {
                    return mid;
            }
        }
        return -1;
    }
    //二分法查找——>对于有序的数组（升序或降序）
    public static void main7(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Scanner scan = new Scanner(System.in);
        System.out.print("输入要查找的数:");
        int n = scan.nextInt();
        System.out.println("数的下标是："+binarySearch(array,n));
    }

    public static int findNum(int[] array, int n) {
        for(int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                return i;
            }
        }
        return -1;
    }
    //顺序查找————在数组中查找某一个数
    public static void main6(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Scanner scan = new Scanner(System.in);
        System.out.print("输入要查找的数：");
        int n = scan.nextInt();
        //int ret = numOne(array, n);
        System.out.println("数的下标是："+findNum(array, n));
    }

    public static double avgOfArray(int[] array) {
        int sum = 0;

        /*for(int i = 0; i < array.length; i++) {
            sum += array[i];
        }*/

        for (int i: array) {
            sum += i;
        }
        return (double)sum / array.length;
    }
    public static void main5(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};
        double ret = avgOfArray(array);
        System.out.println(ret);
    }

    //求数组中的最大值
    public static int maxOfArray(int[] array) {
        int max = array[0];
        for(int i = 1; i < array.length; i++) {
            max = (max > array[i] ? max:array[i]);
        }
        return max;
    }
    public static void main4(String[] args) {
        int[] array = new int[]{1,2,333,44,55,66,222,11};
        int ret = maxOfArray(array);
        System.out.println(ret);

        //System.out.println(maxOfArray(array));
    }

    public static void main3(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] newArr = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            newArr[i] = array[i];
        }
        System.out.println(Arrays.toString(newArr));
    }

    public static void main2(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] newArr = Arrays.copyOfRange(array,5,9);  //[2 , 3)
        System.out.println(Arrays.toString(newArr));
    }

    public static void main1(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int[] newArr = Arrays.copyOf(array,array.length);
        System.out.println(Arrays.toString(newArr));
    }
}
