import java.util.Scanner;

public class Mian2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[][] array = new int[n][n];
            int x = n;
            while (x > 0) {
                String str = sc.next();
                for (int i = 0; i < n; i++) {
                    char c = str.charAt(i);
                    array[n - x][i] = c - '0';
                }
                x--;
            }
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if (array[i][j] == 0) {
                        if (array[i - 1][j] == 1 && array[i][j - 1] == 1
                            && array[i][j + 1] == 1 && array[i + 1][j] == 1) {
                            array[i][j] = 1;
                        }else if (array[i - 1][j] == 1 && array[i][j - 1] == 1
                                && array[i][j + 1] == 1 && array[i + 1][j] == 0) {
                            if (array[i + 1][j - 1] == 1 && array[i + 1][j + 1] == 1
                                    && array[i + 2][j] == 1 ) {
                                array[i][j] = 1;
                                array[i + 1][j] = 1;
                            }
                        }else if (array[i - 1][j] == 1 && array[i][j - 1] == 0
                                && array[i][j + 1] == 1 && array[i + 1][j] == 1) {
                            if (array[i + 1][j - 2] == 1 && array[i - 1][j - 1] == 1
                                    && array[i + 2][j - 1] == 1 ) {
                                array[i][j] = 1;
                                array[i + 1][j] = 1;
                            }
                        }
                    }else {
                        if (array[i - 1][j] == 0 && array[i][j - 1] == 0
                                && array[i][j + 1] == 0 && array[i + 1][j] == 0) {
                            array[i][j] = 0;
                        }else if (array[i - 1][j] == 0 && array[i][j - 1] == 0
                                && array[i][j + 1] == 0 && array[i + 1][j] == 1) {
                            if (array[i + 1][j - 1] == 0 && array[i + 1][j + 1] == 0
                                    && array[i + 2][j] == 0 ) {
                                array[i][j] = 0;
                                array[i + 1][j] = 0;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
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
