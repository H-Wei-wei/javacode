public class testDemo1 {

    public boolean Find(int target, int [][] array) {
        int rowSize = array.length;
        int colSize = array[0].length;
        int i = rowSize - 1, j = 0;
        while (i >= 0 && j < colSize) {
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

    public String replaceSpace(StringBuffer str) {
//        String string = "";
//        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            if (c == ' ') {
//                string += "%20";
//                continue;
//            }
//            string += c;
//        }
//        return string;
        return str.toString().replace(" ", "%20");
    }

    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder("hello world!");
//        String string = sb.toString().replaceAll(" ", "%20");
//        System.out.println(string);
        String string = "hello world";
        String str = string.replace("h", "a");
        System.out.println(str);
    }
}
