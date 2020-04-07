package com.bit.src;

import java.util.Arrays;

class Student implements Comparable<Student> {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
public class TestDemo {
    public static void main(String[] args) {
        Student[] student = new Student[2];
        student[0] = new Student("ghuyi",12);
        student[1] = new Student("erha",18);
        System.out.println(Arrays.toString(student));
        Arrays.sort(student);
        System.out.println(Arrays.toString(student));

    }
}
