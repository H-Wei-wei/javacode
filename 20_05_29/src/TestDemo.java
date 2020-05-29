

public class TestDemo {
    public static void main(String[] args) {
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

}
