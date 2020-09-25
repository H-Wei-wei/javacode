import java.util.Arrays;

public class Main {
    public static int sort (String inData) {
        String s = "";
        s = inData;
//        System.out.println(s);
        String[] strings = s.split(" ");
//        System.out.println(Arrays.toString(strings));
        int[] arr = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }
//        System.out.println(Arrays.toString(arr));
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j] ) {
                    count++;
                }
            }
        }
//        System.out.println(count);
        return count;
    }

//    public static int[] pushIntArray (int[] arr, int pushOffset) {
//        for (int j = 0; j < pushOffset; j++) {
//            int tmp = arr[arr.length - 1];
//            int k = arr.length - 1 - 1;
//            for (; k >= 0 ; k--) {
//                arr[k + 1] = arr[k];
//            }
//            arr[0] = tmp;
//        }
//        return arr;
//    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9};
        //int[] ret = pushIntArray(array, 2);
        //System.out.println(Arrays.toString(ret));
        String s = "19 5 9 255";
        sort(s);
    }
}
