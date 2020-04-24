import java.util.LinkedList;
import java.util.Queue;

/**
 * 层序遍历二叉树
 */

public class TestTree {

    static class TreeNode {
        private char val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public static void levelOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 取出队首元素
            TreeNode cur = queue.poll();
            // 访问当前节点
            System.out.print(cur.val+" ");
            // 将当前节点的左右子树入队列
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    public static TreeNode built() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        F.left = G;

        return A;
    }

    public static void main(String[] args) {
        TreeNode root = built();
        TestTree tree = new TestTree();
        TestTree.levelOrder(root);
    }
}
