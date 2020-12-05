public class Main3 {

    public int[] exchangeAB(int[] AB) {
       AB[0] = AB[0] + AB[1];
       AB[1] = AB[0] - AB[1];
       AB[0] = AB[0] - AB[1];
       return AB;
    }

    public String[] getGray(int n) {
        String[] s = new String[(int)Math.pow(2, n)];
        if (n == 1) {
            s[0] = "0";
            s[1] = "1";
            return s;
        }
        String[] ret = getGray(n - 1);
        for (int i = 0; i < s.length/2; i++) {
            s[i] = "0" + ret[i];
            s[s.length - 1 - i] = "1" + ret[i];
        }
        return s;
    }
}
