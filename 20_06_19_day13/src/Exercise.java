public class Exercise {
//    private int count;
//    public static void main(String[] args) {
//        Exercise exercise = new Exercise(88);
//        System.out.println(exercise.count);
//    }
//    Exercise (int a) {
//        count = a;
//    }
    public String name = "abc";

    public static void main(String[] args) {
        Exercise exercise1 = new Exercise();
        Exercise exercise2 = new Exercise();
        System.out.println(exercise1.equals(exercise2) + "," +
                exercise1.name.equals(exercise2.name));
    }
}
