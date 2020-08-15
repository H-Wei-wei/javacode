import java.util.LinkedList;
import java.util.Queue;

public class TreeExercise {
    class Node {
        public char val;
        public Node left;
        public Node right;

        public Node(char val) {
            this.val = val;
        }
    }

    // 完全二叉树的判定
    private static boolean isComplete(Node root) {
        if (root == null) {
            return false;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean isFirst = true;
        while (!queue.isEmpty()) {
            if (isFirst) {
                if (root.left != null && root.right == null) {
                    isFirst = false;
                    queue.offer(root.left);
                }else if (root.left == null && root.right != null) {
                    return false;
                }else if (root.left == null && root.right == null) {
                    isFirst = false;
                }else {
                    queue.offer(root.left);
                    queue.offer(root.right);
                }
            }else {
                if (root.left != null && root.right != null) {
                    return false;
                }
            }
        }
        return true;
    }

    // 最近公共祖先
    private static Node lca = null;
    private static Node func(Node root, Node p, Node q) {
        if (root == null) {
            return null;
        }
        isFunc(root, p, q);
        return lca;
    }
    private static boolean isFunc(Node root, Node p, Node q) {
        if (root == null) {
            return false;
        }
        int left = isFunc(root.left, p, q) ? 1 : 0;
        int right = isFunc(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if ((left + right + mid) == 2) {
            lca = root;
        }
        return (left + right + mid) > 0;
    }

}
