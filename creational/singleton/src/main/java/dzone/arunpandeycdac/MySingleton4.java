package dzone.arunpandeycdac;

/**
 * https://dzone.com/articles/singleton-pattern-a-deep-dive
 * The below multi-threaded way of implementation can avoid the race condition to ensure it won't violate the philosophy of singleton and with the help of double-checked locking using object-level lock will achieve the same.
 * This implementation guarantees thread safe; but the extra object is required to just keep a lock which is not a good practice.
 * Another downside is that someone can take the advantage of using class-level lock as your lock is on a different object.
 */
class MySingleton4 {
    private static MySingleton4 mySingleton;
    private static final Object lock = new Object();
    private MySingleton4(){}
    public static MySingleton4 getInstance(){
        if(null == mySingleton) {
            synchronized(lock) {
                if(null == mySingleton) {
                    mySingleton = new MySingleton4();
                }
            }
        }
        return mySingleton;
    }
}