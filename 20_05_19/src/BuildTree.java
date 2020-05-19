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

    // 记录字符串字符下标
    public static int index = 0;

    // 中序遍历
    private static void inOrder(TreeNode root) {
         if (root == null) {
             return;
         }
         inOrder(root.left);
        System.out.print(root.val+" ");
         inOrder(root.right);
    }

    private static TreeNode buildTree(String line) {
        // 可能会有多组数据，每个字符串都得从 0 开始遍历
        index = 0;
        return buildTreeHelper(line);
    }
    // 辅助递归的方法
    private static TreeNode buildTreeHelper(String line) {
        char ch = line.charAt(index);
        if (ch == '#') {
            return null;
        }
        // 创建节点
        TreeNode node = new TreeNode(ch);
        index++;
        node.left = buildTreeHelper(line);
        index++;
        node.right = buildTreeHelper(line);
        return node;
    }
}
