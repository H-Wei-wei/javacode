import java.util.LinkedList;
import java.util.List;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

}
public class TestTree2{
     private static List<Integer> built(List<Integer> result) {
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

         result.add(A.val);
         result.add(B.val);
         result.add(C.val);
         result.add(D.val);
         result.add(E.val);
         result.add(F.val);
         result.add(G.val);
         result.add(H.val);

         return result;
     }
  /*  static class Solution {
        public List<Integer> preOrderTraversal(TreeNode root) {
            if(root == null) {
                return null;
            }
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
            return ;
        }
    }
*/
    public static void main(String[] args) {
        List<Integer> result = new LinkedList<>();
        List<Integer> ret = built(result);
        System.out.println(ret);

    }
}