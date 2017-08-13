package dzone.arunpandeycdac;

/**
 * https://dzone.com/articles/singleton-pattern-a-deep-dive
 * Here's a vanilla way of implementing a singleton using an eager loading mechanism, which is thread-safe as well.
 */
public class MySingleton1 {
    private static final MySingleton1 mySingleton = new MySingleton1();
    private MySingleton1(){}
    public static MySingleton1 getInstance(){
        return mySingleton;
    }
}