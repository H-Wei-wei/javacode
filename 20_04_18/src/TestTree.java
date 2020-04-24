
/**
 * 二叉树
 */

public class TestTree {
    static class Node {
        private char val;
        private Node lift;
        private Node right;

        public Node(char val) {
            this.val = val;
        }

        // 通过 built 方法来创建一个二叉树
        private static Node built() {
            Node A = new Node('A');
            Node B = new Node('B');
            Node C = new Node('C');
            Node D = new Node('D');
            Node E = new Node('E');
            Node F = new Node('F');
            Node G = new Node('G');
            Node H = new Node('H');

            A.lift = B;
            A.right = C;
            B.lift = D;
            B.right = E;
            E.lift = G;
            E.right = H;
            C.right = F;

            return A;
        }

        // 前序  ( N L R )
        private static void prevOder(Node root){
            // 当根节点为空时
            if(root == null) {
                return;
            }
            System.out.print(root.val+" ");
            prevOder(root.lift);
            prevOder(root.right);
        }

        // 中序 （ L N R）
        private static void midOder(Node root) {
            if(root == null) {
                return;
            }
            midOder(root.lift);
            System.out.print(root.val+" ");
            midOder(root.right);
        }

        // 后序
        private static void lastOder(Node root) {
            if(root == null) {
                return;
            }
            lastOder(root.lift);
            lastOder(root.right);
            System.out.print(root.val+" ");
        }

        public static void main(String[] args) {
            Node root = built();

            prevOder(root);
            System.out.println();

            midOder(root);
            System.out.println();

            lastOder(root);
        }
    }

}
