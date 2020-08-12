
class Node {
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }
}
public class TreeDemo {

    // 通过 built 方法来创建一个二叉树
    public static Node built() {
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
    // 前序
    public static void prevTree (Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        prevTree(root.left);
        prevTree(root.right);
    }
    public static void main(String[] args) {
        Node root = built();
        prevTree(root);
        //System.out.println(root);
    }
}
