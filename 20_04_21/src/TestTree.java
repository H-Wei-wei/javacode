
/**
 * 二叉树的遍历
 */

public class TestTree {

    static class Node {
        private char val;
        private Node left;
        private Node right;

        public Node(char val) {
            this.val = val;

        }
    }

    // 创建一个树
    private static Node built() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        E.right = H;
        C.right = F;

        return A;

    }

    // 前序遍历二叉树
    private static void prevOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val+" ");
        prevOrder(root.left);
        prevOrder(root.right);

    }

    // 中序遍历二叉树
    private static void midOrder(Node root) {
        if(root == null) {
            return;
        }
        midOrder(root.left);
        System.out.print(root.val+" ");
        midOrder(root.right);

    }

    // 后序遍历二叉树
    private static void lastOrder(Node root) {
        if(root == null) {
            return;
        }
        lastOrder(root.left);
        lastOrder(root.right);
        System.out.print(root.val+" ");
    }

    public static void main(String[] args) {
        Node root = built();
        prevOrder(root);
        System.out.println();
        midOrder(root);
        System.out.println();
        lastOrder(root);
        System.out.println();
    }

}
