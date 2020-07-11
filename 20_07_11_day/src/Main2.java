/**
 *
 * 时间复杂度O(n), 空间复杂度O(1)。
 * firstBuy表示第一次买入的最大收益，因为是买入所以是负值；
 * firstSell表示第一次卖出的最大收益；
 * secondBuy表示第二次买入的最大收益；
 * secondSell表示第二次卖出的最大收益；
 *
 */
public class Main2 {
    public static int calculateMax(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;

        for (int curPrice : prices) {
            firstBuy = Math.max(firstBuy, -curPrice);
            firstSell = Math.max(firstSell, firstBuy + curPrice);
            secondBuy = Math.max(secondBuy,firstSell - curPrice);
            secondSell = Math.max(secondSell, secondBuy + curPrice);
        }
        return secondSell;
    }

    public static void main(String[] args) {
        int[] array = {3,8,5,1,7,8};
        System.out.println(calculateMax(array));
    }
}
