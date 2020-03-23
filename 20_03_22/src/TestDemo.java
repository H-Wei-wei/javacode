//import java.util.Arrays;

public class TestDemo {

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0,10);
        myArrayList.add(1,20);
        myArrayList.add(2,30);
        myArrayList.add(3,40);
        myArrayList.display();
        myArrayList.add(2,99);
        myArrayList.display();

       /* myArrayList.add(2,99);
        myArrayList.display();*/

       /* System.out.println(myArrayList.contains(30));
        System.out.println(myArrayList.search(30));
        System.out.println(myArrayList.getPos(3));
        System.out.println(myArrayList.size());

        myArrayList.remove(20);
        myArrayList.display();

        myArrayList.clear();
        System.out.println("===============");
        myArrayList.display();
        System.out.println("===============");
*/
    }

    
    public static void main2(String[] args) {
        int[] array1 = {1,2,3,4,5};
        int[] array2 = new int[]{1,2,3};
        int[] array3 = new int[6];
        array3[0] = 1;
    }

    public static int sum1(int[] array) {
        int ret = 0;
        for (int x : array) {
            ret += x;
        }
        return ret;
    }

    //可变参数编程
    public static int sum(int... array) {
        int ret = 0;
        for (int x : array) {
            ret += x;
        }
        return ret;
    }

    public static void main1(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(sum(array));

        // 匿名数组
        System.out.println(sum1(new int[]{1,2,3}));

        System.out.println(sum(1, 2, 3, 4, 5));
    }
}

