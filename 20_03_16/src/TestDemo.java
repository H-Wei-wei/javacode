import java.util.Arrays;
import java.util.Scanner;

public class TestDemo {
    
    public static int max(int[] array) {
        int ret = 0;
        for(int i = 0; i < array.length - 1; i++) {
            ret = array[i] > array[i+1] ? array[1] : array[i+1];
        }
        return ret;
    }
    public static void main8(String[] args) {
        int[] array = new int[]{1,23,44,33,35,11,22,66,99};
        int ret = max(array);
        System.out.println(ret);
    }

    public static void main7(String[] args) {
        int[] array1 = new int[10];
        int[] array2 = new int []{1,2,3,4,5,6,7,8,9,10};
        int[] array3 = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(array1));
        for(int i: array2) {
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i = 0; i < array3.length; i++) {
            System.out.print(array3[i]+" ");
        }
    }

    public static void main6(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = new int[10];
        for(int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }
        System.out.println();
        for(int i: array) {
            System.out.print(i+" ");
        }
    }

    public static void main5(String[] args) {
        int[] array = new int[100];
        int i = 0;
        for(i = 0; i < array.length; i++) {
            array[i] = i + 1;
            System.out.print(array[i]+" ");
        }
    }

    public static void printArray(int[]array) {
        for(int i:array){
            System.out.print(i+" ");
        }
    }
    public static void main4(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        printArray(array);
    }

    public static void transform(int[] array) {
        int[] num = new int[3];
        for(int i = 0; i < array.length; i++) {
            num[i] = 2 * array[i];
            System.out.print(num[i]+" ");
        }
    }
    public static void main3(String[] args) {
        int[] array = new int[]{1,2,3};
        transform(array);
    }

    public static int sum(int[] array) {
        int num = 0;
        for(int i = 0; i < array.length; i++) {
            num += array[i];
        }
        return num;
    }
    public static void main2(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};
        int ret = sum(array);
        System.out.println(ret);
    }

    public static double avg(int[] array) {
        double sum = 0;
        for(int i = 0;i < array.length; i++) {
            sum += array[i];
        }
        return sum/array.length;
    }
    public static void main1(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};
        double ret = avg(array);
        System.out.println(ret);
    }
}
