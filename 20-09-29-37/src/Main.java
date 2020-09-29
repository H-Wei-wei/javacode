import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                System.out.println(1);
            }
            String[] array = new String[n];
            List<String> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                array[i] = sc.next();
                list.add(array[i]);
            }
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (array[i].length() > array[j].length()) {
                        swap(array, i, j);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.print(array[i] + " ");
            }
        }
    }

    private static void swap(String[] array, int i, int j) {
        String tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
