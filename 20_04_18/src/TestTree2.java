import java.util.LinkedList;
import java.util.List;


class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }

}
public class TestTree2{
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
     public static List<Integer> preOrderTraversal(TreeNode root) {
         List<Integer> result = new LinkedList<>();
         if(root == null) {
             return result;
         }
         result.add(root.val);
         result.addAll(preOrderTraversal(root.left));
         result.addAll(preOrderTraversal(root.right));
         return result;
     }

    public static void main(String[] args) {
        TreeNode root = built();
        System.out.println(preOrderTraversal(root));

    }
}