class A {
    public A(String str) {
    }
}

public class Exercise {
//    private float f = 1.0f;
//    int m = 12;
//    static int n = 1;
//    public static void main(String[] args) {
//        Exercise e = new Exercise();
//        e.f = 2.3f;
//        e.m = 1;
//        Exercise.n = 1;
//
//    }
    public static void main(String[] args) {
//        A classA = new A("he");
//        A classB = new A("he");
//        System.out.println(classA.equals(classB));
//        System.out.println(classA == classB);
//        int a = 10;
//        double b = 12.2;
//        System.out.println('A' + a + b);
        String fool = args[1];
        String foo2 = args[2];
        String fool3 = args[3];

        System.out.println(args.length);

    }
    public class MyRunnable implements Runnable {
        @Override
        public void run() {
            new Thread(new MyRunnable()).run();
        }
    }
}
