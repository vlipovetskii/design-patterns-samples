package habrahabr.spiff;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

/**
 * https://habrahabr.ru/post/129494/
 * https://stackoverflow.com/questions/26285520/implementing-singleton-with-an-enum-in-java
 */
@CreationalPattern.Singleton
public enum Singleton2_Enum_Singleton {
    INSTANCE;
}