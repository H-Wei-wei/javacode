import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 */
public class TestYH {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // 第一行
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        result.add(firstList);
        if (numRows == 1) {
            return result;
        }
        //第二行
        List<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if (numRows == 2) {
            return result;
        }
        for (int row = 3; row <= numRows; row++) {
            List<Integer> curLine = new ArrayList<>();
            curLine.add(1);
            // 获取到前一行
            List<Integer> prevLine = result.get(row - 1 - 1);
            // 计算当前行[2, cow - 1]列的值
            for (int col = 2; col <= row - 1; col++) {
                int sum = prevLine.get(col - 1 - 1) + prevLine.get(col - 1);
                curLine.add(sum);
            }
            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        TestYH t = new TestYH();
        List<List<Integer>> lists = t.generate(n);
        System.out.println(lists);
    }
}
