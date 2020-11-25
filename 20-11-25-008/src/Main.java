class Person {
    private String name = "Person";
    int age = 0;
}

public class Main extends Person{
    public String grade;
    public static void main(String[] args) {
        //四舍五入
//        System.out.println(Math.round(11.5));
//        System.out.println(Math.round(-11.5));
//        System.out.println(Math.round(11.8));
//        System.out.println(Math.round(-11.8));

//        String s1 = "hello";
//        String s2 = "he" + new String("llo");
//        System.out.println(s1 == s2);
        Person p = new Main();
        System.out.println(p.age);
    }
}
