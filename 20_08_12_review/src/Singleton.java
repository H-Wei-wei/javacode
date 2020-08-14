
public class Singleton {

//    // 饿汉模式
//    public Singleton singleton = new Singleton();
//
//    public Singleton getSingleton() {
//        return singleton;
//    }

    // 懒汉模式
    public volatile Singleton singleton = null;

    public Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
