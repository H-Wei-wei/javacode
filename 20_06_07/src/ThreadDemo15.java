
/**
 * 线程案例：
 *  1、单例模式
 *  “饿汉”模式
 */

public class ThreadDemo15 {

    // “饿汉”模式-------线程安全
    static class Singleton {
        // 私有的构造方法，外部类不可以 new 实例，但是因为此类是 ThreadDemo11 的内部类，可以 new
        private Singleton() { }

        public static Singleton instance = new Singleton();
        public static Singleton getInstance() {
            return instance;
        }
    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}
