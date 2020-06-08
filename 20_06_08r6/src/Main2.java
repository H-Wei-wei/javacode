import java.util.Scanner;

/**
 * 格子里放蛋糕，满足欧几里得距离不等于 2
 */
public class Main2 {
    public static void main(String[] args) {
        int[] array = {2,3,4,5,6,7,8,9};
        for (int x : array) {
            System.out.println(x);
            break;
        }
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x = sc.nextInt();  // 格子长
            int y = sc.nextInt();   // 格子宽

            int first = (x / 4) * 2 + (x % 4 <= 2 ? x%4 : 2);
            int second = ((x - 2) / 4) * 2 + ((x - 2) % 4 <= 2 ? (x - 2) % 4 : 2);

            int sum = (x / 4) * (2 * first + 2 * second);
            if(x % 4 > 0){
                sum+=first; //余下一行的情况
            }
            if(y % 4 > 1){
                sum+=first;//余下两行的情况，和上边一个进行累加
            }
            if(y % 4 > 2){
                sum+=second;//余下三行的情况，和上边两个进行累加
            }
            System.out.println(sum);}
    }
}
