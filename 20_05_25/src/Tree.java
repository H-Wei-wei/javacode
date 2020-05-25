import java.util.Arrays;

public class Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        return ((leftDepth - rightDepth) >= -1 && (leftDepth - rightDepth) <= 1) && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
//
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetricalHelper(pRoot.left, pRoot.right);
    }

    private boolean isSymmetricalHelper(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot == null && rightRoot == null) {
            return true;
        }
        if (leftRoot == null || rightRoot == null) {
            return false;
        }
        return leftRoot.val == rightRoot.val && isSymmetricalHelper(leftRoot.left, rightRoot.right) && isSymmetricalHelper(leftRoot.right, rightRoot.left);
    }

//
    private int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        return 1 + ((leftDepth > rightDepth) ? leftDepth: rightDepth);
    }

}

