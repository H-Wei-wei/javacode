import java.util.*;

public class Main {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k < 0 || k > input.length) {
            return list;
        }
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Map<Integer,String> map = new HashMap<>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                String str = c + "";
                int count = 1;
                for (j = i + 1; j < s.length(); j++) {
                    int c2 = s.charAt(j);
                    if (c2 >= '0' && c2 <= '9') {
                        str = str + c2;
                        count++;
                    }else {
                        map.put(count, str);
                        break;
                    }
                }
            }
            i = i + j;
        }
        System.out.println(map);

//        int[] array = {4,5,1,6,2,7,3,8};
//        System.out.println(GetLeastNumbers_Solution(array, 4));
    }
}
