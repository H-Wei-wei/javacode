import java.util.Arrays;

class Test{
    private int[] array;

    public Test() {

    }

    public Test(int[] array) {
        this.array = array;
    }

    public static void exchange(int[] array1, int[] array2) {
        for(int i = 0; i < array1.length; i++) {
            int tmp = array1[i];
            array1[i] = array2[i];
            array2[i] = tmp;
        }
    }

    public void exch(){
        for(int i = 0; i < this.array.length; i++) {
            if(this.getArray()[i] % 2 == 0) {
                System.out.print(this.array[i]+" ");
            }
        }
        for(int i = 0; i < this.array.length; i++) {
            if(this.array[i] % 2 != 0) {
                System.out.print(this.array[i]+" ");
            }
        }
    }


    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }
}

public class TestDemo {

    public static void main4(String[] args) {
        Test test = new Test();
        test.setArray(new int[]{1,2,3,4,5,6,7,8,9,10});
        test.exch();

        //System.out.println(Arrays.toString(test.getArray()));
    }

    public static void main3(String[] args) {
        Test test1 = new Test();
        test1.setArray(new int[]{1,2,3,4,5});

        Test test2 = new Test();
        test2.setArray(new int[]{6,7,8,9,10});

        Test.exchange(test1.getArray(),test2.getArray());

        System.out.println(Arrays.toString(test1.getArray()));
        System.out.println(Arrays.toString(test2.getArray()));

    }

    public static void exchenge1(int[] array1,int[] array2) {
        for(int i = 0; i < array1.length; i++) {
            int tmp = array1[i];
            array1[i] = array2[i];
            array2[i] = tmp;
        }
    }
    public static void main2(String[] args) {
        int[] array1 = {1,2,3,4,5,6,7};
        int[] array2 = {6,7,8,9,1,2,3};
        exchenge1(array1,array2);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));

    }

    public static void swap(int[] array) {
        /*for(int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 0) {
                System.out.print(array[i]+" ");
            }
        }
        for(int i = 0; i < array.length; i++) {
            if(array[i] % 2 != 0) {
                System.out.print(array[i]+" ");
            }
        }*/
        int i = 0;
        while (i < array.length) {
            if(array[i] % 2 == 0) {
                System.out.print(array[i]+" ");
            }
            i++;
        }
        i = 0;
        while(i < array.length) {
            if (array[i] % 2 != 0) {
                System.out.print(array[i]+" ");
            }
            i++;
        }
    }
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9};
        swap(array);

        //System.out.println(Arrays.toString(array));
    }
}
