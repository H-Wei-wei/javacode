import java.util.Arrays;


public class TestDemo {


    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,9,8,9,10};
        //reverse(array);
        swap(array);
        System.out.println(Arrays.toString(array));
    }
    private static void swap(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (left < right && array[left] % 2 != 0) {
                left++;
            }
            while (left < right && array[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
        }
    }

    private static void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main6(String[] args) {
        int[] array = {1,2,3,4,5,6,9,8,9,10};
        System.out.println(isUp(array));
    }

    private static boolean isUp(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] <= array[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main5(String[] args) {
        int[] array = {1,3,5,7,8,9,10};
        System.out.println(Arrays.binarySearch(array, 3, 5, 8));

        int[] array2 = {1,3,5,7,8,9,10};
        System.out.println(Arrays.equals(array,array2));

        int[] array3 = {4,6,8,2,5,6,9};
        Arrays.sort(array3);
        System.out.println(Arrays.toString(array3));

    }

    public static int binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (key < array[mid]) {
                right = mid - 1;
            }else if (key > array[mid]) {
                left = left + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    public static void main4(String[] args) {
        int[] array = {1,2,4,6,8,9};
        /*int ret = binarySearch(array, 9);
        System.out.println("下标：" + ret);*/

        int ret = Arrays.binarySearch(array, 8);
        System.out.println(ret);
    }
    public static void main3(String[] args) {
        int[] array = {1,2,4,6,8,9,3};
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        System.out.println(max);
    }



    public static void main2(String[] args) {
        int[] array = {1,2,4,6,8,9,3};
        int[] ret = Arrays.copyOf(array, array.length);
        System.out.println(Arrays.toString(ret));
        int[] ret2 = Arrays.copyOfRange(array,3,5); // [ , );
        System.out.println(Arrays.toString(ret2));
        int[] ret3 = array.clone();
        System.out.println(Arrays.toString(ret3));
    }

    public static void main1(String[] args) {
        int[] array = {1,2,4,6,8,9,3};
        int[] ret = copyArray(array);
        System.out.println(Arrays.toString(ret));
    }

    private static int[] copyArray(int[] array) {
        int[] ret = new int[array.length];
        for (int i = 0; i< array.length; i++) {
            ret[i] = array[i];
        }
        return ret;
    }
}
