import java.util.HashMap;
import java.util.Map;

public class TestDemo {
    public static void main1(String[] args) {
        int[] array = {2,5,7,4,5,8,9,10};
        System.out.println(myToString2(array));
    }

    private static void myToString(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.print(array[i] + ",");
            }
        }
        System.out.print("]");
    }

    private static String myToString2(int[] array) {
        String ret = "[";
        for (int i = 0; i < array.length; i++) {
            ret += array[i];
            if (i < array.length - 1) {
                ret += ",";
            }
        }
        ret += "]";
        return ret;
    }
    public boolean Find(int target, int [][] array) {
        int rowSize = array.length;
        int colSize = array[0].length;
        int i = rowSize - 1 , j = 0;
        while ( i >= 0 && j < colSize ) {
            if (target < array[i][j]) {
                i--;
            }else if (target > array[i][j]) {
                j++;
            }else {
                return true;
            }
        }
        return false;
    }

    /*public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        int size = array.length;
        for (int bound = 0; bound < size; bound++) {
            for (int cur = bound + 1; cur < size; cur++) {
                if (array[bound] > array[cur]) {
                    int tmp = array[bound];
                    for (int i = 1; i < size; i++) {
                        array[i - 1] = array[i];
                    }
                    array[size - 1] = tmp;
                }else {
                    break;
                }
            }
        }
        return array[0];
    }*/

    public int MoreThanHalfNum_Solution(int [] array) {
        int mid = array.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x: array) {
            Integer count = map.get(x);
            if (count == null) {
                map.put(x, 1);
            }else {
                map.put(x, count + 1);
            }
        }
        // 遍历 map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > mid) {
                return entry.getKey();
            }else {
                return 0;
            }
        }
        return 0;
    }
}
