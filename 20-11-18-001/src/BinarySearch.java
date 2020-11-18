public class BinarySearch {

    public static int binarySearch (int[] array, int value) {
        // [0, array.length)
        int left = 0;
        int x = 0;  //比较次数
        int right = array.length;
        while (left < right) {
            int mid = (left + right)/2;
            x++;
            if (array[mid] == value) {
                System.out.println(x);
                return mid;
            }else if (array[mid] < value){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(array, 5));
    }
}
