
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

    // 前序遍历
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

    // 中序遍历
    public static void inOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(true) {
            // 当cur不为空时，入栈，并左移cur
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 访问栈顶元素并出栈，当栈为空时，结束循环
            if(stack.isEmpty()) {
                break;
            }
            TreeNode top = stack.pop();
            System.out.print(top.val+" ");
            // 判断右子树
            cur = top.right;

        }
    }

    // 后序遍历
    public static void postOrderTraversal (TreeNode root){
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        //  prev 用来记录上一个被访问过的节点. 初始情况下没有任何节点被访问过.
        TreeNode prev = null;
        while(true) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if(stack.isEmpty()) {
                break;
            }
            // 判断栈顶元素是否被访问过了
            TreeNode top = stack.peek();
            if(top.right == null || top.right == prev ) {
                System.out.print(top.val+" ");
                stack.pop();
                prev = top;
            }else {
                cur = top.right;
            }

        }
    }

    public static void main(String[] args) {
        TreeNode root = built();
        TestTree tree = new TestTree();
        postOrderTraversal(root);
    }
}
