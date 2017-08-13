package dzone.arunpandeycdac;

/**
 * https://dzone.com/articles/singleton-pattern-a-deep-dive
 * Here's a very popular implementation using a static class, which brings the powers of lazy loading and thread safety.
 */
public class MySingleton7 {
    private MySingleton7() {}
    private static class SingletonUisngInner {
        private static MySingleton7 mySingleton = new MySingleton7();
    }
    public static MySingleton7 getInstance() {
        return SingletonUisngInner.mySingleton;
    }
}