import java.util.Stack;

/**
 * 链表实现栈
 */

public class MyStack2 {
     static class Node {
        public int val;
        public  Node next;

         public Node(int val) {
             this.val = val;
         }
     }
     // 用链表头作为栈的栈顶,尾节点表示栈低
     // 链表知道头结点就能知道所有的节点
     // 一般使用头结点表示一个链表
     // "用部分表示整体"，即借代

     // 链表有八种形式
     // 带环的 vs 不带环的
     // 单向的 vs 双向的
     // 带傀儡节点的 vs 不带傀儡节点的

    // 设定一个傀儡节点
     Node node = new Node(-1);

     // 头插
     private void push(int value) {
         Node newNode = new Node(value);
         newNode.next = node.next;
         node.next = newNode;
     }

     // 头删
     private Integer pop() {
         Node toDelete = node.next;
         if (toDelete == null) {
             return null;
         }
         node.next= toDelete.next;
         // 返回的是被删掉的元素
         return toDelete.val;
     }

     private Integer peek() {
         if (node.next == null) {
             return null;
         }
         return node.next.val;
     }

    public static void main(String[] args) {
        MyStack2 myStack2 = new MyStack2();
        myStack2.push(1);
        myStack2.push(2);
        myStack2.push(3);
        myStack2.push(4);

        System.out.println(myStack2.peek());

        while(true) {
            Integer cur = myStack2.pop();
            if(cur == null) {
                break;
            }
            System.out.println(cur);
        }

    }

}
