

public class Main {

    public int[] arrayPrint(int[][] arr, int n) {
        int[] array = new int[n * n];
        int index = 0;
        int x = 0;
        int y = n - 1;
        while (x < n) {
            int i = x;
            int j = y;
            while (i < n && j < n) {
                array[index++] = arr[i++][j++];
            }
            if (y > 0) {
                y--;
            }else {
                x++;
            }
        }
        return array;
    }
    public static void main(String[] args) {

    }
}
