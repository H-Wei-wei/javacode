
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
/**
 * 遍历二叉树
 */
public class Tree {

//    /**
//     * 递归实现二叉树的遍历
//     */
//
//    // 前序遍历二叉树
//    public static void prevTree(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        System.out.println(root.val + " ");
//        prevTree(root.left);
//        prevTree(root.right);
//    }
//    // 中序遍历
//    public static void midTree(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        midTree(root.left);
//        System.out.println(root.val + " ");
//        midTree(root.right);
//    }
//    // 后序遍历
//    public static void lastTree(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        lastTree(root.left);
//        lastTree(root.right);
//        System.out.println(root.val + " ");
//    }

        /**
         * 非递归实现二叉树的遍历
        */
        // 前序遍历
        public static void prevTree(TreeNode root) {
            if (root == null) {
                return;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                System.out.println(cur.val + " ");
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }

        // 中序遍历
        public static void midTree(TreeNode root) {
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
                System.out.println(top.val + " ");
                cur = top.right;
            }
        }

        // 后序遍历
        public static void lastTree(TreeNode root) {
            if (root == null) {
                return;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            TreeNode prev = null; //用来被记录上一个被访问的节点
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
                    System.out.println(top.val + " ");
                    stack.pop();
                    prev = top;
                }else {
                    cur = top.right;
                }
            }
        }

        // 层序遍历
        public static void lineTree(TreeNode root) {
            if (root == null) {
                return;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                System.out.println(cur.val + " ");
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
}
