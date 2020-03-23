import java.util.Arrays;

public class MyArrayList {

    private int[] elem;  // null
    private int usedSize;  // 0

    //设置默认容量
    public static final int DEFAULT_SIZE = 10;

    public MyArrayList() {
        this.elem = new int[DEFAULT_SIZE];
        this.usedSize = 0;
    }
    // 打印顺序表
    public void display() {
        for (int i = 0; i < usedSize; i++) {
            System.out.print(elem[i]+" ");
        }
        System.out.println();
    }

    public boolean isFull() {
        if(this.usedSize == this.elem.length) {

            return true;
        }
        return false;
    }

    private void grow() {
        this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        //判断数组是否是满的
        if(isFull()) {
            /*System.out.println("顺序表是满的");
            return;*/

            //运行时候的异常
            //throw new RuntimeException("顺序表是满的");

            //扩容
            //int[] elem = new int[this.elem.length*2];
            grow();
        }

        //判断pos的合法性
        /*if(pos < 0 || pos > this.usedSize) {
            *//*System.out.println("pos位置不合法");
            return;*//*

            //越界异常 -- 遇到异常，程序就不执行了
            throw new ArrayIndexOutOfBoundsException("pos位置不合法");
        }*/

        checkPos(pos);
        //int i = 0;
        for(int i = this.usedSize - 1; i >= pos; i--) {
            elem[i+1] = elem[i];
        }
        elem[pos] = data;
        this.usedSize++;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        if(isEmpty()) {
            /*System.out.println("空");
            return false;*/
            throw new RuntimeException("顺序表为空");
        }
        for(int i = 0; i < this.usedSize; i++) {
            if(elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }
    public boolean isEmpty() {
        if(usedSize == 0) {
            return true;
        }
        return false;
    }

    // 查找某个元素对应的位置
    public int search(int toFind) {
        if(isEmpty()) {
            /*System.out.println("空");
            return false;*/
            throw new RuntimeException("顺序表为空");
        }
        for(int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    //判断pos位置是否合法
    private void checkPos(int pos) {
        if(pos < 0 || pos > this.usedSize) {
            throw new ArrayIndexOutOfBoundsException("pos位置不合法");
        }
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(isEmpty()) {
            throw new RuntimeException("顺序表为空");
        }
        checkPos(pos);
        return this.elem[pos];
    }

    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {


    }
    //删除第一次出现的关键字key
    public void remove(int key) {
        //调用search方法，看返回值，-1就没有这个数 ，就不用删除了
        //index接受返回值
        int index = search(key);
        if(index != -1) {
            for(int i = index; i < this.usedSize-1; i++) {
                this.elem[i] = this.elem[i+1];
            }
        }
        usedSize--;
    }
     // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }

    // 清空顺序表
    public void clear() {
        this.usedSize = 0;
    }

}
