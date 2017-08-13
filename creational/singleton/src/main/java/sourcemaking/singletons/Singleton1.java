package sourcemaking.singletons;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

/**
 *
 */

/**
 * See <a href="https://sourcemaking.com/design_patterns/singleton/java/1">Singleton pattern</a>
 * The inner class is referenced no earlier (and therefore loaded no earlier by the class loader)
 * than the moment that getInstance() is called.
 * Thus, this solution is thread-safe without requiring special language constructs
 * (i.e. volatile or synchronized).
 */
@CreationalPattern.Singleton
public class Singleton1 {

    private Singleton1() {
    }

    private static class SingletonHolder {
        private static final Singleton1 INSTANCE = new Singleton1();
    }

    public static Singleton1 getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
