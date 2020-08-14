import java.util.Stack;

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
        System.out.print(root.val + " ");
        prevTree(root.left);
        prevTree(root.right);
    }
    public static void prevOrder(Node root) {
        if(root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack .push(root);
        while(!stack .isEmpty()) {
            Node cur = stack.pop();
            System.out.print(cur.val + " ");
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    // 中序
    public static void midTree (Node root) {
        if (root == null) {
            return;
        }
        midTree(root.left);
        System.out.print(root.val + " ");
        midTree(root.right);
    }
    public static void midOrder (Node root) {
        if(root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while(true) {
            // 当cur不为空时，入栈，并左移cur
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 取栈顶元素并访问了，如遇空栈，就结束循环
            if(stack.isEmpty()) {
                break;
            }
            Node top = stack.pop();
            System.out.print(top.val+" ");
            // 判断右子树
            cur = top.right;
        }
    }

    // 后序
    public static void postTree (Node root) {
        if (root == null) {
            return;
        }
        postTree(root.left);
        postTree(root.right);
        System.out.print(root.val + " ");
    }
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node prev = null;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            Node top = stack.peek();
            if(top.right == null || top.right == prev ) {
                System.out.print(top.val+" ");
                stack.pop();
                prev = top;
            }else {
                cur = top.right;
            }
        }
    }
    public static void main(String[] args) {
        Node root = built();
        //prevTree(root);
        //midTree(root);
        postTree(root);
        System.out.println();
        //prevOrder(root);
        //midOrder(root);
        postOrder(root);
    }
}
