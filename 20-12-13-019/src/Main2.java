public class Main2 {
    public static void main(String[] args) {
        int FW = 10;
        int MSR = 0;
        for (int i = 1; i <= 30 ; i++) {
            MSR = (int) (MSR + Math.pow(2, i - 1));
        }
        FW = FW * 30;
        System.out.println(FW);
        System.out.println(MSR);
    }
}
