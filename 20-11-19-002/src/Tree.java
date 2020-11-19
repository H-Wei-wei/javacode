import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;
    public TreeNode(char val) {
        this.val = val;
    }
}
public class Tree {

    // 前序遍历（递归）
    public static void prev(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        prev(root.left);
        prev(root.right);
    }

    // 前序遍历（非递归）
    public static void prevOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.print(cur.val + " ");
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    // 中序遍历（非递归）
    public static void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            cur = top.right;
        }
    }

    // 后序遍历（非递归）
    public static void lastOrder(TreeNode root) {
        if (root == null) {
             return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            TreeNode top = stack.peek();
            if (top.right == null || top.right == prev) {
                System.out.print(top.val + " ");
                stack.pop();
                prev = top;
            }else {
                cur = top.right;
            }
        }
    }

    // 层序遍历
    public static void lineOrder(TreeNode root) {
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

    public static TreeNode createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        return A;
    }

    //
    public static void main(String[] args) {
        TreeNode root = createTree();
        prev(root);
        System.out.println();
        prevOrder(root);
        System.out.println();
        midOrder(root);
        System.out.println();
        lastOrder(root);
        System.out.println();
        lineOrder(root);
    }
}
