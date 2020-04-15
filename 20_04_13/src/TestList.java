import java.util.List;

class Test extends Object {
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

public class TestList {
    public static void main(String[] args) {
        // 匿名内部类
        // 内部类是指定义在某个类内或是某个方法内的类
        // 匿名是指没有创建类的名字，只知道这个类是个 Object 类的子类
        // { } 括号里是这个内部类的实现代码
       /* Object o = new Object() {
                @Override
                public boolean equals(Object obj) {
                    return super.equals(obj);
                }

            };
        o.equals(10);*/

       Object o = new Test();
    }


}
