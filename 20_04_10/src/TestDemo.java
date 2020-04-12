import java.util.Random;

public class TestDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,10,11,12};
        System.out.println(isSorted(arr));
    }
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main6(String[] args) {
        for (int i = 1; i < 999999; i++) {
            int count = 0;
            int num = i;
            //判断个数
            while(num != 0) {
                count++;
                num = num / 10;
            }

            int sum = 0;
            num = i;
            while( num!= 0) {
                sum += Math.pow(num%10,count);
                num = num/10;
            }
            //比较
            if(i == sum) {
                System.out.println(i);
            }

        }
    }

    public static void main5(String[] args) {
        Random random = new Random();
        int rand = random.nextInt(100);
        System.out.println(rand);
    }

    public static void main4(String[] args) {
        int i = 0;
        int j = 0;
        for (i = 1; i <= 100; i++) {
            for (j = 2; j < i/2; j++) {
                if(i % j == 0){
                    break;
                }
            }
            if(j >= i/2){
                System.out.println(i);
            }
        }
    }

    public static void main3(String[] args) {
        int i = 0;
        int j = 0;
        for (i = 1; i <= 100; i++) {
            for (j = 2; j < i; j++) {
                if(i % j == 0){
                    break;
                }
            }
            if(j >= i){
                System.out.println(i);
            }
        }
    }

    public static void main2(String[] args) {
        for (int year = 1000; year <= 2000; year++) {
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                System.out.print(year+" ");
            }
        }
    }

    public static void main1(String[] args) {
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            /*int tmp = i;
            while(tmp != 0) {
               if (tmp % 10 == 9) {
                   count++;
               }
               tmp = tmp / 10;
            }*/
            //个位
            if(i % 10 == 9) {
                count++;
            }
            //十位
            if(i / 10 == 9){
                count++;
            }
        }
        System.out.println(count);
    }

}
