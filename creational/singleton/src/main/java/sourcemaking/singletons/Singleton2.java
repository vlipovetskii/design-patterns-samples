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
public class Singleton2 {

    /**
     * http://tutorials.jenkov.com/java-concurrency/volatile.html#the-java-volatile-visibility-guarantee
     */
    private static volatile Singleton2 instance;

    private Singleton2() {}

    public static Singleton2 getInstance(String value) {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
