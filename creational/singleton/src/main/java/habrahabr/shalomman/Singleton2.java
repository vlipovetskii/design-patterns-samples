package habrahabr.shalomman;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

/**
 * https://habrahabr.ru/post/27108/
 */
@CreationalPattern.Singleton
public class Singleton2 {
    private static Singleton2 instance = new Singleton2();

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
            return instance;
    }
}