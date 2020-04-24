/**
 * 二叉树的常见运算
 */

public class TestTree2 {
    static class Node {
        private char val;
        private Node left;
        private Node right;

        public Node(char val) {
            this.val = val;

        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
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

/*
    // 求二叉树的节点个数
    private static int treeSize = 0;
    private static void size(Node root) {
        if (root == null) {
            return;
        }
        treeSize++;
        size(root.left);
        size(root.right);
    }
*/

    private static int size(Node root) {
        if (root == null) {
            return 0;
        }
        // 树的总结点数 = 根节点 + 左子树节点数 + 右子树的节点数
        return 1 + size(root.left) + size(root.right);
    }

    // 叶子节点
/*
    private static int leafSize = 0;
    private static void LeafSize(Node root){
        if (root == null) {
            return;
        }
        // 当该节点的左节点和右节点为空时，为叶子节点
        if (root.left == null && root.right == null) {
            leafSize++;
            return;
        }
        LeafSize(root.left);
        LeafSize(root.right);
    }
*/

    private static int leafSize(Node root) {
        // 空树
        if(root == null) {
            return 0;
        }
        if(root.right == null && root.left == null) {
            return 1;
        }
        return leafSize(root.left) + leafSize(root.right);
    }

    // 求第k层的节点个数
    private static int kLevelSize(Node root,int k) {
        if(root == null || k <= 0) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }
        // 不是第一层
        // k 层节点个数 = 左子树 k-1 层节点个数 + 右子树 k-1 层节点个数
        return kLevelSize(root.left,k-1)+kLevelSize(root.right,k-1);
    }

    // 判断当前元素是否在二叉树里存在
/*
    private static Node result = null;
    private static void find(Node root, char toFInd) {
        if(root == null) {
            return;
        }
        if(root.val == toFInd) {
            result = root;
            return;
        }
        find(root.left,toFInd);
        find(root.right,toFInd);

    }
*/
    private static Node find(Node root,char toFind) {
        if(root == null) {
            return null;
        }
        // 如果要找的元素等于根节点，就返回根节点
        if(root.val == toFind) {
            return root;
        }
        // 如果要找的元素在左子树里，返回该结果
        Node result = find(root.left,toFind);
        if(result != null) {
            return result;
        }
        // 如果左子树中没有找到。就在右子树中找，并返回结果
        return find(root.right, toFind);

    }

    public static void main(String[] args) {
        // 创建二叉树
        Node root = built();

        // size(root);
        // System.out.println(treeSize);

        // System.out.println(size(root));

        // LeafSize(root);
        // System.out.println(leafSize);

        // System.out.println(leafSize(root));

        // System.out.println(kLevelSize(root, 2));

        // find(root,'h');
        // System.out.println(result);

        System.out.println(find(root,'H'));
    }
}
