package sourcemaking.singletons;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

/**
 *
 */

/**
 * See <a href="https://sourcemaking.com/design_patterns/singleton/java/2">Singleton pattern</a>
 * Thread safe Singleton
 *
 */
@CreationalPattern.Singleton
public class Singleton3 {

    /**
     * http://tutorials.jenkov.com/java-concurrency/volatile.html#the-java-volatile-visibility-guarantee
     */
    private static volatile Singleton3 instance;

    private Singleton3() {}

    public static Singleton3 getInstance(String value) {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
