
public class TestDemo3 {
    public static String rotatePassword (String[] s1, String[] s2) {
        String s = "";
        for (int n = 0; n < 4; n++ ) {
            for (int i = 0; i < s1.length; i++) {
                for (int j = 0; j < s1[0].length(); j++) {
                    char c = s1[i].charAt(j);
                    if (c == '0') {
                        s += s2[i].charAt(j);
                    }
                }
            }
            s1 = func(s1, s2);
        }
        return s;
    }

    private static String[] func(String[] s1, String[] s2) {
        String[] ret = new String[s1.length];
        for (int i = 0; i < s1.length; i++) {
            String s = "";
            for (int j = s1[i].length() - 1; j >= 0; j--) {
                s += s1[j].charAt(i);
            }
            //System.out.println(s + "  +");
            ret[i] = s;
        }
        return ret;
    }

    public static void main(String[] args) {
        String[] s1 = new String[]{"1101","1010","1111","1110"};
        String[] s2 = new String[]{"ABCD","EFGH","IJKL","MNPQ"};
        System.out.println(rotatePassword(s1, s2));
    }
}
