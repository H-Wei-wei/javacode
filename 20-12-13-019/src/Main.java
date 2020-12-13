import sun.misc.GC;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int n = sc.nextInt();
            String res = "";
            double Max_num = 0;
            for (int i = 0; i <= s.length() - n; i++) {
                int GC_Len = 0;
                String Mid_s = "";
                for (int j = i; j < i + n; j++) {
                    if (s.charAt(j) == 'G' || s.charAt(j) == 'C') {
                        GC_Len++;
                    }
                    Mid_s += s.charAt(j);
                }
                //System.out.println(Mid_s);
               // System.out.println(GC_Len);
                double num = (GC_Len * 1.0)/ n;
               // System.out.println(num);
                if (num > Max_num) {
                    Max_num = num;
                    res = Mid_s;
                }
            }
            System.out.println(res);
        }
    }
}
