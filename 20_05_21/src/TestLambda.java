import java.util.Arrays;
import java.util.Comparator;

public class TestLambda {
    static class Student {
        String name;
        int grade;

        public Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", grade=" + grade +
                    '}';
        }
    }
    public static void main(String[] args) {
        Student s1 = new Student("a", 87);
        Student s2 = new Student("b", 91);
        Student s3 = new Student("c", 88);

        Student[] students = {s1, s2, s3};

/*        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.grade - o2.grade;
            }
        });
  */

        //Arrays.sort(students, (o1, o2) -> o1.grade - o2.grade);

        Arrays.sort(students,(Student o1, Student o2) -> {
            return o1.name.compareTo(o2.name);
        });

        System.out.println(Arrays.toString(students));
    }
}
