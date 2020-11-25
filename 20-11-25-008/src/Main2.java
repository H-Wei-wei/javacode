import javax.xml.crypto.Data;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
//            String s = sc.next();
//            String res = "";
//            int maxLen = 0;
//            for (int i = 0; i < s.length(); i++) {
//                char c = s.charAt(i);
//                int len = 0;
//                String string = "";
//                if (c <= '9' && c >= '0') {
//                    for (int j = i ; j < s.length(); j++) {
//                        char c1 = s.charAt(j);
//                        if (c1 > '9' || c1 < '0') {
//                            i = j;
//                            break;
//                        }
//                        string += c1;
//                        len++;
//                    }
//                }
//                if (len > maxLen) {
//                    maxLen = len;
//                    res = string;
//                }
//            }
//            System.out.println(res);

            String s = sc.next();
            String[] array = s.split("\\D");
            //System.out.println(Arrays.toString(array));
            String res = "";
            int maxLen = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i].length() > maxLen) {
                    maxLen = array[i].length();
                    res = array[i];
                }
            }
            System.out.println(res);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
            String data =  sdf.format(new Date());
            System.out.println(data);
            String[] date = data.split("\\D");
            System.out.println(Arrays.toString(date));
        }
    }
}
