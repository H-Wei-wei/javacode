import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Student {
    public String name;
    public int age;
    public String grade;
    public String school;

    public Student(String name, int age, String grade, String school) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
public class TestMap {
    public static void main(String[] args) {
        Student s1 = new Student("初一", 18, "大一","清华");
        Student s2 = new Student("初二", 19, "大二","北大");
        Student s3 = new Student("初三", 20, "大三","哈佛");

       Map<String,Student> studentMap = new HashMap<>();
       studentMap.put(s1.name,s1);
       studentMap.put(s2.name,s2);
       studentMap.put(s3.name,s3);

       String name = "初三";
        System.out.println(studentMap.get(name));

        Student s4 = new Student("初二",22,"大四","陕科大");
        studentMap.put(s4.name,s4);
        String name2 = "初二";
        System.out.println(studentMap.get(name2));

        Student ss = studentMap.getOrDefault("初五",new Student("初五",12,"一年级","小学"));
        System.out.println(ss);

        // 遍历 Map
        for (Map.Entry<String,Student> entry : studentMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        // 用迭代器来遍历
        Iterator<Map.Entry<String,Student>> iterator = studentMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,Student> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
