import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeInterview {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        result.clear();
        levelOrderHelper(root,0);
        return result;
    }

    private void levelOrderHelper(TreeNode root, int level) {
        if (level == result.size() ) {
            // 当前 level 在 result 中没有对应的行，加入一行
            // 防止下面的 get 操作出现下标越界操作
            result.add(new ArrayList<>());
        }
        List<Integer> curRow = result.get(level);
        curRow.add(root.val);// 先序遍历的“访问”操作
        if (root.left != null) {
            levelOrderHelper(root.left, level + 1);
        }
        if (root.right != null) {
            levelOrderHelper(root.right, level + 1);
        }
    }

    // 二叉树的最近公共节点
    // 用来保存最近公共节点
    public TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        findNode(root, p, q);
        return lca;
    }
    // [约定] 如果在 root 中能找到 p 或 q ,就返回 true，否则就返回 false
    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        // 后续遍历
        int left = findNode(root.left, p, q) ? 1 : 0;
        int right = findNode(root.right, p, q) ? 1 : 0;
        // 访问根节点
        int mid = (root == p || root == q)? 1 : 0;
        if (left + right + mid == 2) {
            lca = root;
        }
        return (left + right + mid) > 0;
    }

    // 二叉搜索树到双向链表
    public TreeNode Convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 中序遍历,递归处理左子树
        // left 为左子树的头节点
        TreeNode left = Convert(root.left);
        // 处理根节点
        // 先找到链表的尾节点，前提是 左子树不为空
        TreeNode leftTail = left;
        while (leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        // 此时 leftTail 为这个链表的最后一个节点
        // 链表的尾插法
        if (leftTail != null) {
            leftTail.right = root;
            root.left = leftTail;
        }
        // 处理右子树
        TreeNode right = Convert(root.right);
        if (right != null) {
            root.right = right;
            right.left = root;
        }
        // 返回整个链表的头结点，如果左子树为空，就返回 root 根节点
        return left != null ? left : root;
    }
}
