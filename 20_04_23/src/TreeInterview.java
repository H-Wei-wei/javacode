

public class TreeInterview {

    static class TreeNode {
        private char val;
        private TreeNode left;
        private TreeNode right;

    }

    // 判断两棵树是否一样，即树结构一样，节点值一样
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 当两个树都为空时，两棵树是一样的
        if(p == null && q == null){
            return true;
        }
        // 当一个为空另一个不为空时，树不一样
        if(p == null || q == null) {
            return false;
        }
        // 两棵树一样的条件是：
        // p.val == q.val 和 p.left == q.left 和 p.right == q.right
        return p.val == q.val && isSameTree(p.left,q.left)
                && isSameTree(p.right,q.right);
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {

        if(s == null) {
            return false;
        }
        // s 中是否包含 t 的条件：
        //    s 是否和 t 相等 || s.left 是否和 t 相等
        //      || s.right 是否和 t 相等
        return isSameTree(s,t) || isSubtree(s.left ,t) || isSubtree(s.right,t);
    }

    // 求二叉树的深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 判断叶子节点
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 左子树的深度
        int leftDepth = maxDepth(root.left);
        // 右子树的深度
        int rightDepth = maxDepth(root.right);
        //  return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
        return 1 + (Math.max(leftDepth, rightDepth));
    }

    // 判断二叉树是否是平衡二叉树
    public Boolean isbalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        // 判断叶子节点
        if(root.left == null && root.right == null) {
            return true;
        }
        // 左子树的深度
        int leftDepth = maxDepth(root.left);
        // 右子树的深度
        int rightDepth = maxDepth(root.right);
        // 二叉树平衡  ==>> 左右子树高度相差不大于 1 && 左子树平衡 && 右子树平衡
        return (leftDepth - rightDepth <= 1 && leftDepth - rightDepth >= -1)
                && isbalanced(root.left) && isbalanced(root.right);
    }

    // 对称二叉树
    public Boolean isMymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMierror(root.left,root.right);
    }
    public Boolean isMierror(TreeNode r1,TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if(r1 == null || r2 == null) {
            return false;
        }
        // 二叉树对称 ----》 左右子树根节点相等 && 左子树left == 右子树right
        //                  && 左子树right== 右子树left
        return r1.val == r2.val && isMierror(r1.left,r2.right) &&
                isMierror(r1.right,r2.left);
    }

}
