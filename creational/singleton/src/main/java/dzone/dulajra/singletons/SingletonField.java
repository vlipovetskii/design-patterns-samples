package dzone.dulajra.singletons;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

/**
 * https://dzone.com/articles/java-singletons-using-enum
 * Singleton with public static final field.
 * Not safe with deserialization.
 *
 * @author Dulaj Atapattu
 */
@CreationalPattern.Singleton
public class SingletonField {

    public static final SingletonField INSTANCE = new SingletonField();

    private SingletonField() {
    }

}