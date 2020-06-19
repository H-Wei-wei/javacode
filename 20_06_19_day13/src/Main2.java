import sun.reflect.generics.tree.Tree;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class Main2 {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        MirrorHelper(root.left, root.right);
    }

    private void MirrorHelper(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return;
        }
        int tmp = root1.val;
        root1.val = root2.val;
        root2.val = tmp;
        MirrorHelper(root1.left, root2.right);
        MirrorHelper(root1.right, root2.right);
    }

}
