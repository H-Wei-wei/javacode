
/**
 * 二叉搜索树
 */

public class BinarySearchTree {
    static class Node {
        public int key;
        public int Value;
        public Node left;
        public Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    // 用 root 表示根节点，就能根据根节点访问到整个树
    // 当 root 为空时，表示是一棵空树
    public static Node root = null;

    // 查找
    private static Node find(int key) {
        Node cur = root;
        while (cur != null) {
            if (key < cur.key) {
                // 当 Key 该节点时，去左子树中查找
                cur = cur.left;
            }else if (key > cur.key) {
                // key 大于该节点时，去右子树中找
                cur = cur.right;
            }else {
                // key 等于该节点时，返回当前节点
                return cur;
            }
        }
        // 表示没找到，返回 null
        return null;
    }

    // 插入
    public static Node insert() {

    }

    // 删除
    public static void remove() {

    }

    public static void main(String[] args) {

    }
}
