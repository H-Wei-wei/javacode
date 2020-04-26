
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 用非递归方法遍历二叉树
 */

public class TestTree {

    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    private static TreeNode built() {
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(7);
        TreeNode H = new TreeNode(8);

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        E.right = H;
        C.right = F;

        return A;

    }

    public static void preOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> queue = new Stack<>();
        queue.push(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.pop();
            System.out.print(cur+" ");
            if(cur.left != null) {
                queue.push(cur.left);
            }
            if(cur.right != null) {
                queue.push(cur.right);
            }
        }
    }
    public static void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = root;
        while(true) {
            // 当cur不为空时，入栈，并左移cur
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 当栈为空时，结束循环
            if(stack.isEmpty()) {
                break;
            }
            // 出栈
            TreeNode ret = stack.pop();
            System.out.println(ret.val);

            cur = ret.right;

        }
    }

    public static void main(String[] args) {
        TreeNode root = built();
        TestTree tree = new TestTree();
        inOrder(root);
    }
}
