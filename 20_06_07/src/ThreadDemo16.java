
/**
 *  “懒汉” 模式
 */

public class ThreadDemo16 {

    //  “懒汉模式”-------对于实例创建好之前，线程不安全
    // 等到第一次使用这个实例时再实例化，效率较高（有锁后，效率就低了）
    static class Singleton {
        private Singleton() {}

        //类加载时没有实例化,第一次调用时才实例化 ，相当于“延时加载”
        //  private static Singleton instance = null;

        // 为了保证内存可见，在 instance 前加 volatile
        private volatile static Singleton instance = null;


 /*       synchronized public static Singleton getInstance() {
            // 判断是不安全的
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
 */

//     public static Singleton getInstance() {
//         synchronized(Singleton.class) {
//              if (instance == null) {
//                  instance = new Singleton();
//              }
//         }
//         return instance;
//     }

        public static Singleton getInstance() {
            // 只在第一步实例化的加锁，提高效率
            if (instance == null) {
                synchronized(Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }

    }
 public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}
