import java.lang.reflect.Field;

public class TestString {
    public static void main(String[] args) {
        String str = "hehe";
        String str2 = "HEHE";
        System.out.println(str.equals(str2));
        System.out.println(str.equalsIgnoreCase(str2));//忽略大小写
        System.out.println(str.compareTo(str2));
    }

    public static void main9(String[] args) {
        char[] array = {'h','e','h','e'};
        String str = new String(array);

        char[] array2 = str.toCharArray();
        for (int i = 0; i < array.length ; i++) {
            System.out.println(array2[i]);
        }

        /* //用 charAt 获取字符串中的某个下标对应的字符
        System.out.println(str.charAt(1));*/
        for (int i = 0; i < str.length() ; i++) {
            System.out.println(str.charAt(i));
        }

    }

    public static void main8(String[] args) {
        char[] array = {'h','e','h','e'};
        String str = new String(array);
        System.out.println(str);

        char[] array2 = str.toCharArray();
        for (int i = 0; i < array.length ; i++) {
            System.out.println(array2[i]);
        }

    }

    public static void main7(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str = "hehe";
        //先根据 "value" 找到str中内部存储的value数组
        //1、获取 String 对象的图纸（进一步了解 String 里边的细节）
        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);
        //2、根据图纸找到 str 里边的value 数组
        char[] value = (char[]) field.get(str);

        //然后再修改这个数组的内容即可
        value[0] = 'a';

        System.out.println(str);
    }

    public static void main6(String[] args) {
        String str1 = "hehe";
        str1 = "hh";
        System.out.println(str1);//hh

        String str = new String("hhhh");
        str = "haha";
        System.out.println(str);

    }

    public static void main5(String[] args) {
        String str1 = "hehe";
        // intern() 方法主动在字符串常量池中查找
        // 如果在池中不存在，就把这个 String的对象 加入到池子中
        //如果已经存在，就可以舍弃当前对象，直接获取池子中对应对象的的引用
        String str2 = new String("hehe").intern();
        System.out.println(str1 == str2);
    }

    public static void main4(String[] args) {
        String str1 = "hehe";
        String str2 = "hehe";
        String str3 = "hehe";
        String str4 = new String("hehe");
        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
        System.out.println(str3 == str4);

    }

    public static void main3(String[] args) {
        String str1 = "hehe";
        System.out.println("hehe".equals(str1));//这种更好
        System.out.println(str1.equals("hehe"));

    }

    public static void main2(String[] args) {
        String str1 = "hehe";
        String str2 = new String("hehe");
        //对于引用类型，==表示比较的是对象的身份（即比较两个引用中地址是否一样）
        System.out.println(str1 == str2);
        //比较两内容（值），用  (.equals)
        System.out.println(str1.equals(str2));
    }

    public static void main1(String[] args) {
        //创建几个String对象
        String str = "hehe";
        String str2 = new String("hehe");
        str = "haha";
        System.out.println(str2);
        char[] ch = {'a','b','c'};
        String str3 = new String(ch);
    }
}
