import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int target = Integer.parseInt(sc.nextLine());
//        String s = sc.nextLine();
//        String[] arr = s.split(" ");
//        int[] nums = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            nums[i] = Integer.parseInt(arr[i]);
//        }
//
//        int result = search(nums, target);
//
//        System.out.println(result);
//    }
//
//    public static int search(int[] nums, int target) {
//        int i = 0;
//        for (; i < nums.length; i++) {
//            if (nums[i] == target) {
//                break;
//            }
//        }
//        return i;
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //建筑物个数
        int n = Integer.parseInt(sc.nextLine());
        int[][] buildings = new int[n][3];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            for (int j = 0; j < arr.length; j++) {
                buildings[i][j] = Integer.parseInt(arr[j]);
            }
        }

        //获取天际线，待实现
        List<List<Integer>> skyline = getSkyline(buildings);

        //输出skyline到标准输出
        for (List<Integer> point : skyline) {
            int size = point.size();
            for (int i = 0; i < size; i++) {
                System.out.print(point.get(i));
                if (i < size-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        //todo 实现算法
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            List<Integer> list = new ArrayList<>();
            int tmp = buildings[i][0];
            int n = i;
            for (int j = i + 1; j < buildings.length- 1; j++) {
                if (tmp < buildings[j][0]) {
                    continue;
                }else {
                    tmp = buildings[j][0];
                    n = j;
                }
            }
            list.add(tmp);
            list.add(buildings[n][1]);
        }
        return null;
    }
}
