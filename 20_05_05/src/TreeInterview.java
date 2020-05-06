
public class TreeInterview {
    class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 两棵树为空时,是相等的树
        if(p == null && q == null) {
            return true;
        }
        // 当一棵树为空，一棵树不为空时，两树不相等·
        //if((p == null && q != null )||(p != null && q == null)) {
        if(p == null || q == null) {
            return false;
        }
        // 两树相等 ==》p.val == q.val && p的左子树等于q左子树 && P 的右子树等于q的右子树
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) {
            return false;
        }

        return isSameTree(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // 判断叶子节点
        if(root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        // 深度 == 1(根节点) + 左右子树中深度大的
        return 1 + (Math.max(leftDepth, rightDepth));
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        // 当前节点左右子树高度差是否小于等于1 && 左子树平衡 && 右子树平衡
        return (leftDepth - rightDepth <= 1) && (leftDepth - rightDepth >= -1) &&
                isBalanced(root.left) && isBalanced(root.right);
    }
}
