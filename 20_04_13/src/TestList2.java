import java.util.ArrayList;
import java.util.List;

public class TestList2 {

    /**
     * 杨辉三角
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        // 第一行
        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if(numRows == 1) {
            return result;
        }
        // 第二行
        List<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        if(numRows == 2) {
            return result;
        }
        // 第三行以后
        // 1、第 i 行，有 i 个数据
        // 2、第 i 行，第一个数与最后一个数据都为 1
        // 3、（第 i 行 j 列数据） = （第 i-1 行 j-1 列数据 ）+ （第 i -1 行 j 列数据）
        for(int row = 3; row < numRows; row++) {
            // 当前行
            List<Integer> curLine = new ArrayList<>();
            // 前一行
            // row-1 为 curLine 所在行的下标，row-1-1 为前一行的下标
            List<Integer> prevLine = result.get(row - 1 - 1);
            // curLine 的第一个数
            curLine.add(1);
            // cuLine 的中间数
            for(int col = 2; col <= row-1;col++) {
                int num1 = prevLine.get(col-1-1);
                int num2 = prevLine.get(col-1);
                curLine.add(num1+num2);
            }
            //  curLine 的最后一个数
            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }
}
