package dzone.arunpandeycdac;

/**
 * https://dzone.com/articles/singleton-pattern-a-deep-dive
 * A multi-threaded approach can avoid the race condition to ensure it won't violate the philosophy of a singleton.
 * But in the example below, making the whole method 'synchronized' is not a good approach, as we need to put the lock on the object creation statement only.
 */
class MySingleton {
    private static MySingleton mySingleton;
    private MySingleton(){}
    public synchronized static MySingleton getInstance(){
        if(null == mySingleton) {
            mySingleton = new MySingleton();
        }
        return mySingleton;
    }
}