package dzone.dulajra.singletons;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

/**
 * https://dzone.com/articles/java-singletons-using-enum
 * Singleton with static factory method.
 * Not safe with deserialization.
 *
 * @author Dulaj Atapattu
 */
@CreationalPattern.Singleton
public class SingletonFactory {

    private static final SingletonFactory INSTANCE = new SingletonFactory();

    private SingletonFactory() {
    }

    public static SingletonFactory getInstance() {
        return INSTANCE;
    }

}