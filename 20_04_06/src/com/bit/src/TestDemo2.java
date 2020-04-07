package com.bit.src;

/**
 * 复习拷贝
 */

import java.util.Arrays;

public class TestDemo2 {

    public static void swap(int a,int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }
    public static void main4(String[] args) {
        int a = 5;
        int b = 4;
        System.out.println("a = "+a+" b = "+b);
        swap(a,b);
        System.out.println("a = "+a+" b = "+b);
    }

    //克隆
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4};
        int[] array2 = array1.clone();
        System.out.println(Arrays.toString(array2));
    }

    public static void func(int[] array){
        array[3] = 0;
    }
    public static void main2(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println(Arrays.toString(array));
        func(array);
        System.out.println(Arrays.toString(array));
    }

    //copyOf拷贝数组
    public static void main1(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6};
        int[] array2 = Arrays.copyOfRange(array,2,3);//[ )
        int[] array3 = Arrays.copyOf(array,3);
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));

    }
}
