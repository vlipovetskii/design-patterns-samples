package dzone.arunpandeycdac;

/**
 * https://dzone.com/articles/singleton-pattern-a-deep-dive
 * Another multi-threaded-based implementation (to avoid race conditions) can be achieved with the help of double-checked locking using a class-level lock.
 * Here, marking the MySingleton object as volatile will ensure that changes made by one thread should be visible in another.
 * This implementation guarantees thread safety.
 */
class MySingleton5 {
    private volatile static MySingleton5 mySingleton;
    private MySingleton5() {}
    public static MySingleton5 getInstance() {
        if (null == mySingleton) {
            synchronized(MySingleton.class) {
                if (null == mySingleton) {
                    mySingleton = new MySingleton5();
                }
            }
        }
        return mySingleton;
    }
}
