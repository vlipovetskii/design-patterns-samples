package dzone.arunpandeycdac;

/**
 * https://dzone.com/articles/singleton-pattern-a-deep-dive
 * In some circumstances, if your singleton class is inheriting Cloneable interface properties, then your singleton class needs extra care to prevent the singleton design contract.
 * Your singleton class should override the clone method and explicitly throws the CloneNotSupportedException.
 */
class ClonedClass implements Cloneable {
    //Some logic
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public class MySingleton8 extends ClonedClass {
    private MySingleton8() {}
    private static class SingletonUsingInner {
        private static MySingleton8 mySingleton = new MySingleton8();
    }
    public static MySingleton8 getInstance() {
        return SingletonUsingInner.mySingleton;
    }
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}