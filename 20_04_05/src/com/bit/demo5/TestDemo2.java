package com.bit.demo5;

import java.util.Arrays;

class Student implements Comparable<Student> {
    public String name;
    public int age;
    public int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        /*if(this.age < o.age) {
            return -1;
        }
        if(this.age == o.age) {
            return 0;
        }
        return 1;*/
        //return this.age - o.age;
        //return this.score - o.score;
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
public class TestDemo2 {

    /**
     * 对自定义类型进行排序
     * @param args
     */
    public static void main(String[] args) {
        Student[] student = new Student[3];
        student[0] = new Student("a",12,87);
        student[1] = new Student("b",14,88);
        student[2] = new Student("c",16,86);
        Arrays.sort(student);
        System.out.println(Arrays.toString(student));

    }

    public static void main1(String[] args) {
        int[] array = {6,4,2,4,7,9,8};
        Arrays.sort(array) ;
        System.out.println(Arrays.toString(array));
    }
}
