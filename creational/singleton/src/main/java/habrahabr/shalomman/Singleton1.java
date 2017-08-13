package habrahabr.shalomman;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

/**
 * https://habrahabr.ru/post/27108/
 */
@CreationalPattern.Singleton
public class Singleton1 {
    private static Singleton1 instance;

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
