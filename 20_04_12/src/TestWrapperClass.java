/**
 * 包装类
 * 将内置类型包裹在内的类
 */

public class TestWrapperClass {
    public static void main(String[] args) {
/*
        //内置类型到包装类  === 装箱
        Integer i1 = new Integer(10);
        Integer i2 = Integer.valueOf(10);
        System.out.println(i1.equals(i2));

        //从包装类到内置类型 ==== 拆箱
        int i = Integer.valueOf(i1);
        System.out.println(i);
        System.out.println(i);
*/

        //内置类型与包装类可以直接转换
        Integer i = 10;  //自动装箱
        int j = i;    // 自动拆箱
        System.out.println(i);
        System.out.println(j);

        //System.out.println(i.equals(j));
    }

}
