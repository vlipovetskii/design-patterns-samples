package dzone.arunpandeycdac;


/**
 * https://dzone.com/articles/singleton-pattern-a-deep-dive
 * On the other hand, here's an example of implementing a singleton using a lazy loading mechanism. In the case of a multi-threaded application, it would be a bad approach.
 */
class MySingleton2 {
    private static MySingleton2 mySingleton;
    private MySingleton2(){}
    public static MySingleton2 getInstance(){
        if(null == mySingleton) {
            mySingleton = new MySingleton2();
        }
        return mySingleton;
    }
}
