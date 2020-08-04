import java.util.Arrays;

public class MyArrayList {
    public int[] array;
    public int size;
    public static final int default_size = 10;

    public MyArrayList() {
        this.array = new int[default_size];
        this.size = 0;
    }

    // 打印顺序表
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }
    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        for (int i = size - 1; i >= pos; i--) {
            if (size == default_size) {
                // 需进行扩容操作
                array = Arrays.copyOf(array, 2 * default_size);
            }
            if (pos < 0 || pos > size) {
                System.out.println("位置不合法");
                return;
            }
            array[i + 1] = array[i];
        }
        array[pos] = data;
        size++;
    }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        if (size == 0) {
            System.out.println("顺序表为空");
        }
        for (int i = 0; i < size; i++) {
            if (array[i] == toFind) {
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < size; i++) {
            if (array[i] == toFind) {
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public Integer getPos(int pos) {
        if (pos < 0 || pos > size) {
            System.out.println("位置不合法");
            return null;
        }
        return array[pos];
    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if (pos < 0 || pos > size) {
            System.out.println("位置不合法");
            return;
        }
        array[pos] = value;
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        int i = search(toRemove);
        if (i != -1) {
            for (int j =  i + 1; j < size; j++) {
                array[i] = array[i + 1];
            }
        }
        size--;
    }
    // 获取顺序表长度
    public int size() {
        return size;
    }
    // 清空顺序表
    public void clear() {
        size = 0;
    }

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0, 1);
        myArrayList.add(1, 2);
        myArrayList.add(2, 3);
        myArrayList.add(3, 4);
        myArrayList.add(4, 5);
        myArrayList.display();
        System.out.println();
        System.out.println(myArrayList.contains(5));
        myArrayList.remove(4);
        myArrayList.display();
    }
}
