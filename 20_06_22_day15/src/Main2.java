
import java.util.*;

class Student {
    public String name;
    public int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt(); // 表示几名学生
            int flg = sc.nextInt(); // 0表示降序,1表示升序

            List<Student> list=new ArrayList<>();
            for(int i = 0; i < n; i++) {
                list.add(new Student(sc.next(), sc.nextInt()));
            }
            if (flg == 0) {
                Collections.sort(list, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o2.score - o1.score;
                    }
                });
            }else if(flg == 1) {
                Collections.sort(list, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.score - o2.score;
                    }
                });
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).name + " " + list.get(i).score);
            }
        }
    }
}
