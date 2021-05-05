public class Singleton {
    // 双检锁
    private static volatile Singleton singleton = new Singleton();
    private Singleton(){}
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if(singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
