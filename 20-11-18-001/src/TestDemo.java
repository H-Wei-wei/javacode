import java.util.*;

public class TestDemo {

    private int row;
    private int col;
    private int len;
    private char[][] board;
    private char[] chs;
    private int[][] visited;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        row = board.length;
        col = board[0].length;
        len = word.length();
        visited = new int[row][col];
        chs = word.toCharArray();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 从某个位置开始搜索，若匹配，返回true
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false; // 从所有位置开始搜索都不匹配
    }

    private boolean dfs(int i, int j, int start) {
        // 不相等时，返回false
        if (board[i][j] != chs[start]) {
            return false;
        }
        if (start == len - 1) {
            return true;
        }
        visited[i][j] = 1; // 做标记，已访问board[i][j]
        // 上下左右四种情况
        if ((i - 1 >= 0) && visited[i-1][j] == 0 && dfs(i-1, j, start + 1)) {
            return true;
        }
        if ((i + 1 < row) && visited[i+1][j] == 0 && dfs(i+1, j, start + 1)) {
            return true;
        }
        if ((j - 1 >= 0) && visited[i][j-1] == 0 && dfs(i, j-1, start + 1)) {
            return true;
        }
        if ((j + 1 < col) && visited[i][j+1] == 0 && dfs(i, j+1, start + 1)) {
            return true;
        }
        visited[i][j] = 0; // 回溯，从新标记board[i][j]还未访问
        return false;
    }


    public static int trap(int[] height) {
        int sum = 0;
        // 从第二个数开始，取左边最大数，取右边最大数
        // 如果当前值 < min（左最大值，右最大值），就可以存水
        // 当前位置储水量 = min（左最大值，右最大值） - 当前位置数
        for (int cur = 1; cur < height.length; cur++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int j = 0; j < cur; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = cur + 1; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            if (height[cur] < Math.min(leftMax, rightMax)) {
                sum += (Math.min(leftMax, rightMax) - height[cur]);
            }
        }
        return sum;
    }

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        int cur1 = 0;
        int cur2 = n;
        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) {
                res[i] = nums[cur1];
                cur1++;
            }else {
                res[i] = nums[cur2];
                cur2++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(array));

//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int n = sc.nextInt();
//            for(int i = 0; i < n; ++i) {
//                for(int j = 0; j < n; ++j) {
//                    if(i == j){
//                        System.out.print("*");
//                    }
//                    else if(j == n-i-1){
//                        System.out.print("*");
//                    } else {
//                        System.out.print(" ");
//                    }
//                }
//                System.out.println();
//            }
//        }
    }
}
