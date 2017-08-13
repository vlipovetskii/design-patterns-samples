package habrahabr.shalomman;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

/**
 * https://habrahabr.ru/post/27108/
 */
@CreationalPattern.Singleton
public class Singleton5 {
    private static volatile Singleton5 instance;

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null)
                    instance = new Singleton5();
            }
        }
        return instance;
    }

}