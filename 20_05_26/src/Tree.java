import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            int count = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (count > 0) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
                count--;
            }
            result.add(list);
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        if (pRoot == null) {
            return ret;
        }
        Print1Helper(pRoot, 0);
        return ret;
    }

    private void Print1Helper(TreeNode pRoot, int level) {
        if (level == ret.size()) {
            ret.add( new ArrayList<>());
        }
        ArrayList<Integer> curRow = ret.get(level);
        curRow.add(pRoot.val);
        if (pRoot.left != null) {
            Print1Helper(pRoot.left, level + 1);
        }
        if (pRoot.right != null) {
            Print1Helper(pRoot.right, level + 1);
        }
    }
}