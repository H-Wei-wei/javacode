import java.util.Arrays;

class MyValue{
    private int val;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}

class Test{
    private int[] array;

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

}

public class TestDemo {

    public static void main(String[] args) {
        MyLinedList myLinedList = new MyLinedList();
        myLinedList.addFirst(1);
        myLinedList.addFirst(2);
        myLinedList.addFirst(2);
        myLinedList.addFirst(2);
        myLinedList.addLast(5);
        myLinedList.display();
        System.out.println("单链表长度"+myLinedList.size());
        //index处加数
        myLinedList.addIndex(2,8);
        myLinedList.display();
        System.out.println("是否包含key这个数:"+myLinedList.contains(9));

        /*System.out.println("=======删掉第一次出现的key======");
        myLinedList.remove(2);
        myLinedList.display();*/

        System.out.println("=======删除所有的key=======");
        myLinedList.removeAllKey(2);
        myLinedList.display();

        System.out.println("========清空所有的数=======");
        myLinedList.clear();
        myLinedList.display();
    }

    public static void swap3(Test test) {
        for(int i = 0; i < test.getArray().length; i++) {
            if(test.getArray()[i] % 2 == 0) {
                System.out.print(test.getArray()[i]+" ");
            }
        }
        for(int i = 0; i < test.getArray().length; i++) {
            if(test.getArray()[i] % 2 != 0) {
                System.out.print(test.getArray()[i]+" ");
            }
        }
    }
    public static void main4(String[] args) {
        Test test = new Test();
        test.setArray(new int[]{1,2,3,4,5,6,7,8,9});
        swap3(test);
        //System.out.println(Arrays.toString(test.getArray()));
    }

    public static void swap2(Test array1,Test array2) {
        int[] ret = array1.getArray();
        array1.setArray(array2.getArray());
        array2.setArray(ret);
    }
    public static void main3(String[] args) {
        Test array1 = new Test();
        array1.setArray(new int[]{1,2,3,5,6});
        Test array2 = new Test();
        array2.setArray(new int[]{2,3,4,5,6});
        System.out.println(Arrays.toString(array1.getArray()));
        System.out.println(Arrays.toString(array2.getArray()));
        swap2(array1,array2);
        System.out.println("===========交换=========");
        System.out.println(Arrays.toString(array1.getArray()));
        System.out.println(Arrays.toString(array2.getArray()));
    }

    public static void swap(MyValue myValue1,MyValue myValue2) {
        int tmp = myValue1.getVal();
        myValue1.setVal(myValue2.getVal());
        myValue2.setVal(tmp);
    }
    public static void main2(String[] args) {
        MyValue myValue1 = new MyValue();
        myValue1.setVal(10);
        MyValue myValue2 = new MyValue();
        myValue2.setVal(20);
        System.out.println(myValue1.getVal()+" "+myValue2.getVal());
        swap(myValue1,myValue2);
        System.out.println(myValue1.getVal()+" "+myValue2.getVal());

    }

    public static void main1(String[] args) {
        System.out.println("哈哈哈哈哈哈哈");
    }
}
