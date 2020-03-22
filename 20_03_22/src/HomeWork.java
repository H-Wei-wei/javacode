import java.util.Arrays;

class Calculator {

    private int num1;
    private int num2;

    public Calculator() {

    }

    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int add() {
        return this.getNum1() + this.getNum2();
    }

    public int sub() {
        return this.getNum1() - this.getNum2();
    }

    public int mul() {
        return this.getNum1() * this.getNum2();
    }

    public double dev() {
        return (double) this.getNum1() / this.getNum2();
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }
}
class  MyValue {
    public int val;
}
public class HomeWork {

    public static void swap2(MyValue myValue1,MyValue myValue2) {
        int tmp = myValue1.val;
        myValue1.val = myValue2.val;
        myValue2.val = tmp;
    }
    public static void main(String[] args) {
        MyValue myValue1 = new MyValue();
        myValue1.val = 10;
        MyValue myValue2 = new MyValue();
        myValue2.val = 20;
        System.out.println(myValue1.val+" "+myValue2.val);
        swap2(myValue1,myValue2);
        System.out.println(myValue1.val+" "+myValue2.val);
    }

    public static void swap(int[] array) {
        int tmp = array[0];
        array[0] = array[1];
        array[1] = tmp;
    }
    public static void main4(String[] args) {
        int[] array = new int[]{10,20};
        System.out.println(Arrays.toString(array));
        swap(array);
        System.out.println(Arrays.toString(array));
    }

    public static void main3(String[] args) {
        int num1 = 10;
        int num2 = 20;
        System.out.println(num1+" "+num2);
        int tmp = num1;
        num1 = num2;
        num2 = tmp;
        System.out.println(num1+" "+num2);
    }

    public static void main2(String[] args) {
        Calculator calculator1 = new Calculator(20, 10);
        System.out.println(calculator1.add());
        System.out.println(calculator1.sub());
        System.out.println(calculator1.mul());
        System.out.println(calculator1.dev());
    }

    public static void main1(String[] args) {
        Calculator calculator1 = new Calculator();
        calculator1.setNum1(20);
        calculator1.setNum2(10);

        System.out.println(calculator1.add());
        System.out.println(calculator1.sub());
        System.out.println(calculator1.mul());
        System.out.println(calculator1.dev());

    }
}
