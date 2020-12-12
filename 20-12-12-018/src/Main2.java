import sun.security.timestamp.TSRequest;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = sc.nextInt();
            }
            int start = 0;
            List<int[]> list = new ArrayList<>();
            func(array, start, N, list);
            Set<String> sortList = new TreeSet<>();
            for (int[] out: list) {
                if (isLegal(array, out, N)) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < N - 1; i++) {
                        sb.append(out[i] + " ");
                    }
                    sb.append(out[N - 1]);
                    sortList.add(sb.toString());
                }
            }
            for (String l: sortList) {
                System.out.println(l);
            }
        }
    }

    private static boolean isLegal(int[] in, int[] out, int n) {
        LinkedList<Integer> stack = new LinkedList<>();
        int i = 0;
         int j = 0;
         while (i < n) {
             if (in[i] == out[j]) {
                 i++;
                 j++;
             }else {
                 if (stack.isEmpty()) {
                     stack.push(in[i]);
                     i++;
                 }else {
                     int top = stack.peek();
                     if (top == out[j]) {
                         j++;
                         stack.pop();
                     }else if (i < n) {
                         stack.push(in[i]);
                         i++;
                     }
                 }
             }
         }
         while (!stack.isEmpty() && j < n) {
             int top = stack.pop();
             if (top == out[j]) {
                 j++;
             }else {
                 return false;
             }
         }
         return true;
    }

    private static void func(int[] array, int start, int n, List<int[]> list) {
        if (start == n) {  // N == 1
            return;
        }
        if (start == n - 1) {   // N == 2
            int[] mid = array.clone();
            list.add(mid);
            return;
        }
        for (int i = start; i < n; i++) {
            swap(array, start, i);
            func(array, start + 1, n, list);
            swap(array, start, i);
        }
    }

    private static void swap(int[] array, int start, int i) {
        int tmp = array[start];
        array[start] = array[i];
        array[i] = tmp;
    }
}
