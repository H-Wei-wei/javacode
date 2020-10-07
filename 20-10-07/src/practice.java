public class practice {
    public static int fac(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fac(n - 1);
    }

    // 错排算法
    public static int wrongCount(int n) {
        if (n == 1) {
            return 0;
        }else if (n == 2) {
            return 1;
        }
        return (n - 1)*(wrongCount(n - 1) + wrongCount(n - 2));
    }

    public static void main(String[] args) {
//        System.out.println(fac(3));
//        System.out.println(fac(4));
        System.out.println(wrongCount(3));
    }
}
