package dzone.dulajra.singletons;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

/**
 * https://dzone.com/articles/java-singletons-using-enum
 * The best method for creating singletons in java.
 * Singleton property is 100% guaranteed.
 *
 * @author Dulaj Atapattu
 */
@CreationalPattern.Singleton
public enum SingletonEnum {
    INSTANCE
}