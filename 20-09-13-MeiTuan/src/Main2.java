import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] array = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    array[i][j] = sc.nextInt();
                }
            }
            n = n/2;
            while (n >= 1) {
                boolean flg = false;
                for (int i = 0; i < m; i++) {
                    if (array[0][i] == array[n][i]) {
                        break;
                    }else {
                        flg = true;
                    }
                }
                if (flg) {
                    break;
                }
                n = n/2;
            }
            if (n == 0) {
               n = 1;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(array[i][j]);
                    if (j != n - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
