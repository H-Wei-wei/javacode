import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    private static void quickSortHelper(int[] array,int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(array, left, right);
        quickSortHelper(array, left, index - 1);
        quickSortHelper(array, index + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int baseValue = array[right];
        int i = left;
        int j = right;
        while (i < j) {
            while ((i < j) && array[i] <= baseValue) {
                i++;
            }
            while ((i < j) && array[j] >= baseValue) {
                j--;
            }
            swap(array, i, j);
        }
        swap(array, i ,right);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {2,3,6,4,2,8,7,5,1};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
