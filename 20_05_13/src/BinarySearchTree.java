
/**
 * 二叉搜索树
 */

public class BinarySearchTree {
    static class Node {
        public int key;
        public int Value;
        public Node left;
        public Node right;

        public Node(int key,int value) {
            this.key = key;
            this.Value = value;
        }
    }

    // 用 root 表示根节点，就能根据根节点访问到整个树
    // 当 root 为空时，表示是一棵空树
    public  Node root = null;

    // 查找
    private  Node find(int key) {
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
    private  Node insert(int key, int value) {
        // 当树为空树时，让根节点指向此节点
        if (root == null) {
            root = new Node(key, value);
            return root;
        }
        Node cur = root;
        Node prev = null;
        while (cur != null) {
            if (key > cur.key) {
                prev = cur;
                cur = cur.right;
            } else if (key < cur.key) {
                prev = cur;
                cur = cur.left;
            } else {
                //相等的话
                // 1.可以抛出异常
                // 2.可以将该节点的 value 改为新节点的 value（使用这个）
                cur.Value = value;
            }
        }
        // 当 cur 为空时说明找到了插入位置
        Node newNode = new Node(key,value);
        if (key < prev.key) {
            prev.left = newNode;
        } else {
            prev.right = newNode;
        }
        return newNode;
    }

    // 删除
    private  void remove(int key) {
        // 1.先找到要删除节点的位置，再找到该位置的父节点
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if (key < cur.key) {
                // key 小于当前节点，去左子树中找
                parent = cur;
                cur = cur.left;
            }else if (key > cur.key) {
                // key 大于当前节点，去右子树中找
                parent = cur;
                cur = cur.right;
            }else {
                // key 等于当前节点,找到了要删除的节点
                removeKey(parent,cur);
                return;
            }
        }
        // 表示没找到,删除失败
        return;
    }

    private void removeKey(Node parent,Node cur) {
        // 当左右子树都没有时，归类到 1或 2 情况中
        if (cur.left == null) {
            // 1.没有左子树的情况
            if (cur == root) {
                // 1.1当前节点为根节点时
                root = cur.right;
            }else if (cur == parent.left) {
                // 1.2 cur 不为根节点，且为父亲的左子树
                parent.left = cur.right;
            }else if (cur == parent.right) {
                // 1.3 cur 不为根节点，且为父亲的右子树
                parent.right = cur.right;
            }
        }else if (cur.right == null) {
             // 2.没有右子树的情况
            if (cur == root) {
                // 2.1 cur 为根节点时
                root = cur.left;
            }else if (cur == parent.left) {
                // 2.2 cur 不为根节点，且是父亲的左子树
                parent.left = cur.left;
            }else if (cur == parent.right) {
                // 2.3 cur 不为根节点，且为父亲的右子树
                parent.right = cur.left;
            }
        }else {
            // 3.cur 有左子树也有右子树情况
            // 3.1 先找到一个替罪羊节点, 从右子树出发，找到右子树中的最小值
            Node scapeGoat = cur.right;
            Node scapeGoatParent = cur;
            while (scapeGoat.left != null) {
                scapeGoatParent = scapeGoat;
                scapeGoat = scapeGoat.right;

            }
            // 当 左子树 为空时，说明找到了替罪羊
            // 3.2 将替罪羊节点的 key 和 value 赋值给 cur
            cur.key = scapeGoat.key;
            cur.Value = scapeGoat.Value;
            // 3.3再删除替罪羊节点
            if (scapeGoat == scapeGoatParent.left) {
                scapeGoatParent.left = scapeGoat.right;
            }else {
                scapeGoatParent.right = scapeGoat.right;
            }
        }
    }

    // 二叉树前序遍历
    private static void prevOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.key + " ");
        prevOrder(root.left);
        prevOrder(root.right);
    }

    // 二叉树中序遍历
    private static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.key + " ");
        inOrder(root.right);

    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(9,90);
        binarySearchTree.insert(5,50);
        binarySearchTree.insert(2,20);
        binarySearchTree.insert(7,70);
        binarySearchTree.insert(3,30);
        binarySearchTree.insert(6,60);
        binarySearchTree.insert(8,80);

        BinarySearchTree.prevOrder(binarySearchTree.root);
        System.out.println();
        BinarySearchTree.inOrder(binarySearchTree.root);
    }
}
