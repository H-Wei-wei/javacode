import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeInterview {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
          val = x;
      }
  }
  // 前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result =new LinkedList<>();
        if(root == null) {
            return result;
        }
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));

        return result;
    }

    // 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null) {
            return result;
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }

    // 后序遍历
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null) {
            return result;
        }
        result.addAll(postOrderTraversal(root.left));
        result.addAll(postOrderTraversal(root.right));
        result.add(root.val);
        return result;
    }
    public static void main(String[] args) {

    }
}
