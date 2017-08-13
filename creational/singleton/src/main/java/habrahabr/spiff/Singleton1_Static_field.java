package habrahabr.spiff;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

/**
 * https://habrahabr.ru/post/129494/
 */
@CreationalPattern.Singleton
public class Singleton1_Static_field {
    public static final Singleton1_Static_field INSTANCE = new Singleton1_Static_field();
}
