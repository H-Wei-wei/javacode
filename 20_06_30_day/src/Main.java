import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[]  credit = new int[n]; // 学分
            for (int i = 0; i < n; i++) {
                credit[i] = sc.nextInt();
            }
            int[] score = new int[n]; // 成绩
            for (int i = 0; i < n; i++) {
                score[i] = sc.nextInt();
            }
            double GPA = getGPA(credit, score);
            System.out.printf("%.2f",GPA);
        }
    }

    private static double getGPA(int[] credit, int[] score) {
        double GPA = 0;
        double[] creditPoint = new double[credit.length];// 存放所有的学分绩点
        double[] scorePoint = new double[score.length]; // 存放所有的学科绩点
        for (int i = 0; i < score.length; i++) {
            scorePoint[i] = getPoint(score[i]);
        }
        System.out.println(Arrays.toString(scorePoint));
        for (int i = 0; i < credit.length; i++) {
            creditPoint[i] = scorePoint[i] * credit[i];
        }
        System.out.println(Arrays.toString(creditPoint));
        double sumCreditPoint = 0; // 所有学分绩点和
        double sumCredit = 0;// 所有学科绩点和
        for (double x : credit) {
            sumCredit += x;
        }
        System.out.println("学分之和：" + sumCredit);
        for (double x : creditPoint) {
            sumCreditPoint += x;
        }
        System.out.println("学分绩点之和：" + sumCreditPoint);
        GPA = sumCreditPoint / sumCredit;
        return GPA;
    }

    private static double getPoint(int n) {
        double one = 0; // 记录每一科学分绩点
        if (n <= 100 && n >= 90) {
            one = 4.0;
        } else if (n <= 89 && n >= 85) {
            one = 3.7;
        } else if (n <= 84 && n >= 82) {
            one = 3.3;
        } else if (n <= 81 && n >= 78) {
            one = 3.0;
        } else if (n <= 77 && n >= 75) {
            one = 2.7;
        } else if (n <= 74 && n >= 72) {
            one = 2.3;
        } else if (n <= 71 && n >= 68) {
            one = 2.0;
        } else if (n <= 67 && n >= 64) {
            one = 1.5;
        } else if (n <= 63 && n >= 60) {
            one = 1.0;
        } else if (n < 60) {
            one = 0;
        }
        return one;
    }
}
