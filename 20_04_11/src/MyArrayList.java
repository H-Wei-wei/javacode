/**
 * 泛型编程
 */

import java.util.ArrayList;

class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class MyArrayList<T> {
    private T[] array;
    private int size;

    void add (T o) {
        array[size] = o;
        size++;
    }

    T get(int index) {
        return array[index];
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("我");
        arrayList.add("喜");
        arrayList.add("欢");
        arrayList.add("我");

        String ret = (String) arrayList.get(1);
        System.out.println(ret);

        ArrayList<Student> arrayList1 = new ArrayList();
        arrayList1.add(new Student("初一",12));
        arrayList1.add(new Student("初二",11));
        arrayList1.add(new Student("初三",13));

        Student ret2 = arrayList1.get(1);
        System.out.println(ret2);
    }
}
