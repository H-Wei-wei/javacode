import java.util.Scanner;

/**
 * 已知先序遍历结果：abc##de#g##f###
 * 输出中序遍历结果：c b e g d f a
 */
public class BuildTree {
    static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.next();
            // 创建二叉树
            TreeNode root = buildTree(line);
            // 中序遍历
            inOrder(root);
            // 因为可能输入多组数据输出结果得换行
            System.out.println();
        }
    }

    private static void inOrder(TreeNode root) {

    }

    private static TreeNode buildTree(String line) {
        return buildTreeHelper(line);
    }
    // 辅助递归的方法
    private static TreeNode buildTreeHelper(String line) {
        
    }
}
