package habrahabr.shalomman;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

/**
 * https://habrahabr.ru/post/27108/
 */
@CreationalPattern.Singleton
public class Singleton4 {
    private static Singleton4 instance;

    private Singleton4() {
    }

    public static synchronized Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
    
}