import java.util.LinkedList;
import java.util.Queue;

/**
 * 完全二叉树
 *
 */

public class TreeInterview {

    static class TreeNode {
        private char val;
        private TreeNode left;
        private TreeNode right;

    }

    public static boolean wQtree(TreeNode root) {
        if(root == null) {
            return true;
        }
        // 设置一个标志位，true为第一阶段，false为第二阶段
        boolean isFirstStep = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(isFirstStep) {
                // 第一阶段，任意节点必须具备两个子树
                if(root.left != null && root.right != null) {
                    // 当前节点有两个子树，将他们入队列，再继续遍历
                    queue.offer(root.left);
                    queue.offer(root.right);
                }else if(root.left == null && root.right != null) {
                    // 当节点有右子树，没有左子树时，就不是完全二叉树
                    return false;
                }else if(root.left != null && root.right == null) {
                    // 当节点有左子树，没右子树时，将进入第二阶段，并将左子树入队列
                    isFirstStep = false;
                    queue.offer(root.left);
                }else {
                    // 当左右子树都为空时，进入第二阶段
                    isFirstStep = false;
                }
            }else {
                // 第二阶段，要求任意节点没有子树
                if (root.left != null || root.right != null) {
                     // 如果节点存在子树，则不是完全二叉树
                    return false;
                }
            }
        }
        return true;
    }

}
