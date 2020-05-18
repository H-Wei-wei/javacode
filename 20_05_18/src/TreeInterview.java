/**
 * 非递归遍历二叉树
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeInterview {
    static class Node {
        public String val;
        public Node left;
        public Node right;

        public Node(String val) {
            this.val = val;
        }

    }

    private static Node createTree() {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;

        return A;
    }
    //层序遍历
    public static void lineOrder(Node root) {
        if(root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.val+" ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    // 前序遍历
    public static void preOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack .push(root);
        while(!stack .isEmpty()) {
            Node cur = stack .pop();
            System.out.print(cur.val+" ");
            if(cur.right != null) {
                stack .push(cur.right);
            }
            if(cur.left != null) {
                stack .push(cur.left);
            }
        }
    }

    // 中序遍历
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            Node top = stack.pop();
            System.out.print(top.val+" ");
            cur = top.right;
        }
    }

    //  后序遍历
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node prev = null;
        Node cur = root;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            Node top = stack.peek();
            if (top.right == null || top.right == prev) {
                System.out.print(top.val+" ");
                stack.pop();
                prev = top;
            }else {
                cur = top.right;
            }
        }
    }
    public static void main(String[] args) {
        Node root = createTree();
        lineOrder(root);
        System.out.println();
        preOrderTraversal(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }
}
