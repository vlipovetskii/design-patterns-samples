package dzone.dulajra.singletons;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

/**
 * https://dzone.com/articles/java-singletons-using-enum
 * Thread safe singleton with lazy initialization.
 * Not safe with deserialization.
 *
 * @author Dulaj Atapattu
 */
@CreationalPattern.Singleton
public class SingletonLazy {

    private static SingletonLazy INSTANCE = null;

    private SingletonLazy() {
    }

    public static SingletonLazy getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonLazy.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonLazy();
                }
            }
        }
        return INSTANCE;
    }

}