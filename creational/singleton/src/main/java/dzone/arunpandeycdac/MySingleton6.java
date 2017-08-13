package dzone.arunpandeycdac;

/**
 * https://dzone.com/articles/singleton-pattern-a-deep-dive
 * This means of implementation provides an intelligent constructor that will stop the singleton contract violation using reflection.
 */
class MySingleton6 {
    private volatile static MySingleton6 mySingleton;
    //Reflection can't hack to create more than one object.
    private MySingleton6() throws Exception {
        if (null == mySingleton) {
            mySingleton = new MySingleton6();
        } else {
            throw new Exception("It's a singleton class; don't expect more object to get produced");
        }
    }
    public static MySingleton6 getInstance() throws Exception {
        if (null == mySingleton) {
            synchronized(MySingleton6.class) {
                if (null == mySingleton) {
                    mySingleton = new MySingleton6();
                }
            }
        }
        return mySingleton;
    }
}
