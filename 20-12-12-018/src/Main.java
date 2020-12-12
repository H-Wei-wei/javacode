import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
public class Main {
    public static TreeNode createTree() {
        TreeNode A = new TreeNode(8);
        TreeNode B = new TreeNode(6);
        TreeNode C = new TreeNode(10);
        TreeNode D = new TreeNode(5);
        TreeNode E = new TreeNode(7);
        TreeNode F = new TreeNode(9);
        TreeNode G = new TreeNode(11);
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;

        return A;
    }
    public static void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
//        TreeNode left = root.left;
//        TreeNode right = root.right;
        if (root.left != null || root.right != null) {
           TreeNode node = root.left;
           root.left = root.right;
           root.right = node;
        }
        Mirror(root.left);
        Mirror(root.right);
    }

    public static void linOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }
    public static void main(String[] args) {
        TreeNode root = createTree();
        linOrder(root);
        System.out.println();
        Mirror(root);
        linOrder(root);
    }
}
