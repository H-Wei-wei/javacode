import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            List<String[]> loginInfo = new ArrayList<>();
            String nextLine = sc.nextLine();
            while (nextLine != null && !"".equals(nextLine)) {
                String[] str = nextLine.split(",");
                loginInfo.add(str);
                nextLine = sc.nextLine();
            }
//            for (int i = 0; i < loginInfo.size(); i++) {
//                System.out.print(Arrays.toString(loginInfo.get(i)) + " ");
//            }
            String[] array = loginInfo.get(loginInfo.size()-1);
            String userId = array[0];
            //System.out.println(userId);
            int res = func(loginInfo, userId);
            System.out.println(res);
        }
    }

    private static int func(List<String[]> loginInfo, String userId) {
        int n = Integer.parseInt(userId.charAt(userId.length() - 1) + "");
        //System.out.println(n);
        int count = 0;
        for (int i = 0; i < loginInfo.size() - 1; i++) {
            String[] array = loginInfo.get(i);
            int x = Integer.parseInt(array[0].charAt(array[0].length() - 1) + "");
            int y = Integer.parseInt(array[1].charAt(array[1].length() - 1) + "");
            if (x == n) {
               count++;
               continue;
            }
            if (y == n) {
                
            }
        }
        return count;
    }
}
