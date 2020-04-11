package com.bit.str;

import java.util.Arrays;

public class TestString {

    public static void main(String[] args) {
        String str = "\n\t      abc      \n\t";
        System.out.println("["+str+"]");
        System.out.println("["+str.trim()+"]");

    }

    public static void main5(String[] args) {
        String str = "hello world";
        //前闭后开  截取
        System.out.println(str.substring(6,9));
        //表示截取下标6以后的字符
        System.out.println(str.substring(6));


    }

    public static void main4(String[] args) {
        /*String str1 = "aaa,bbb,,ccc";

        //字符串分割 split
        String[] ret = str1.split(",");
        System.out.println(Arrays.toString(ret));*/

        //String str = "199.168.1.1";
        // . 在正则表达式中有特别含义，这里的切分并不是按照 "." 来切分的
        // 如果要按照 . 的文本格式切割，就得转义
        // 正则中通过 \. 来查找文本
        // java中字符串又不能用直接写 \，需要 \\ 来表示 \
        // | * + - 都有类似的情况
        /*String[] ret = str.split("\\.");
        System.out.println(Arrays.toString(ret));*/

        String str = "name=张三&age= 18";
        String[] result = str.split("&");
        for (String tmp:result) {
            String[] tmp2 = tmp.split("=");
            System.out.println(tmp2[0]+":"+tmp2[1]);
        }


    }

    public static void main3(String[] args) {
        String str1 = "hello world";
        String str2 = "wor";

        //通过 contains 方法来判断是否是包含关系
        //System.out.println(str1.contains(str2));

        //indexOf  不仅可以判断包含关系，还能确定所包含字符串的位置
        // 返回值是  str2 在 str1 里的下标位置
        //如果存在多组字符串，返回的是最左侧字符串下标
        //System.out.println(str1.indexOf(str2));
        // lastIndexOf 返回的是最右侧字符串的下标
        //System.out.println(str1.lastIndexOf(str2));

        // startsWith()  endsWith()  以什么开头是什么结尾
        //System.out.println(str1.startsWith("hello"));
        //System.out.println(str1.endsWith("world"));

        //替换字符串
        String ret = str1.replaceAll("hello","hehe");
        System.out.println(str1);
        System.out.println(ret);
        String ret1 = str1.replaceFirst("world","abc");
        System.out.println(ret1);

    }

    public static void main2(String[] args) {
        String str1 = "1";
        String str2 = "2";
        System.out.println(str1.compareTo(str2));
    }

    public static void main1(String[] args) {
        String str1 = "hehe";
        String str2 = new String("hehe").intern();
        System.out.println(str1 == str2);
    }

}
