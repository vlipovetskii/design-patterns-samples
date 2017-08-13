package habrahabr.spiff;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

/**
 * https://habrahabr.ru/post/129494/
 */
@CreationalPattern.Singleton
public class Singleton3_Synchronized_Accessor {
    private static Singleton3_Synchronized_Accessor instance;

    public static synchronized Singleton3_Synchronized_Accessor getInstance() {
        if (instance == null) {
            instance = new Singleton3_Synchronized_Accessor();
        }
        return instance;
    }
}