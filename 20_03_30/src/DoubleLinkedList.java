
    /**
     * 无头双向非循环链
     */

class ListNode {
    public int data;
    public ListNode prev;
    public ListNode next;

    public ListNode(int data) {
        this.data = data;
    }
}

public class DoubleLinkedList {

    public  ListNode head;//头
    public  ListNode last;//尾
    

    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else{
            this.head.prev = node;
            node.next = this.head;
            this.head = node;
        }

    }

    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else {
            this.last.next = node;
            node.prev = this.head;
            this.last = node;
        }

    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        //判断index点是否合法
        if(index < 0 || index > size()) {
            return;
        }
        //找index位置
        ListNode cur = findIndex(index);
        //插入node
        ListNode node = new ListNode(data);
        node.next = cur.next;
        cur.next.prev = node;
        node.prev = cur;
        cur.next = node;
    }
    private  ListNode findIndex(int index){
        ListNode cur = this.head;
        while(index-1 > 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = this.head;
        while(cur != null) {
            if (cur.data == key) {
                return true;
            }
           cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key){

    }

    //删除所有值为key的节点
    public void removeAllKey(int key){

    }

    //得到单链表的长度
    public int size(){
        ListNode cur = this.head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    public void display(){
        ListNode cur = this.head;
        while(cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear(){

    }
}
