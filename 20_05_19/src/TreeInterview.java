import java.util.LinkedList;
import java.util.Queue;

public class TreeInterview {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isComplete(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 设定一个标志位，true 为第一阶段, false 为第二阶段
        boolean isFiestStep = true;
        // 层序遍历二叉树
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (isFiestStep) {
                // 进入第一阶段，当前节点必须具备两个节点
                if (cur.left == null && cur.right == null) {
                    // 左右子树都为空，进入第二阶段
                    isFiestStep = false;
                }else if (cur.left != null && cur.right == null) {
                    // 左子树不为空，右子树为空，进入第二阶段，并将左子树入队列
                    isFiestStep = false;
                    queue.offer(cur.left);
                }else if (cur.left == null && cur.right != null) {
                    // 左子树为空，右子树不为空，则不满足完全二叉树要求，返回 false
                    return false;
                }else {
                    // 左右子树都不为空，将左右子树都入队列
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }else {
                // 第二阶段 当前节点左右子树为空
                if (cur.left != null && cur.right != null) {
                    // 找到不满足要求的节点
                    return false;
                }
            }
        }
        // 遍历结束如果没找到不满足要求的节点，就是完全二叉树
        return true;
    }
}
