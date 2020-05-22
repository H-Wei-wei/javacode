import java.util.Arrays;

// MALE ,FEMALE 可以理解成是 Sex 类型的对象
// enum 可以理解成一种特殊的类，没有属性，也没有方法（只有一些内置的方法和属性）
enum Sex {
    MALE,
    FEMALE,
    UNKNOWN,
}

public class TestEnum {
    public static void main(String[] args) {
        Sex s = Sex.MALE;
        System.out.println(s);

        // Sex。Values() 得到的是一个数组，里边存放的是 Sex 里所有的对象
        System.out.println(Arrays.toString(Sex.values()));
    }
}
