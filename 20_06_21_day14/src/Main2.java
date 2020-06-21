
public class Main2 {
    public static void main(String[] args) {
        long sum1 = 0;//富翁的钱--万元
        long sum2 = 0;// 陌生人的钱--分
        for (int i = 1; i <= 30;i++) {
            sum1 = sum1 + 10;
            sum2 = sum2 + (long) Math.pow(2, i - 1);
        }
        System.out.println(sum1 + " " + sum2);
    }
}
