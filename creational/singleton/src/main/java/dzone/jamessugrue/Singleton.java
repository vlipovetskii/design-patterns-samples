package dzone.jamessugrue;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

/**
 * // https://dzone.com/articles/design-patterns-singleton
 */
@CreationalPattern.Singleton
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
