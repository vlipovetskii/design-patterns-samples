package habrahabr.spiff;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

/**
 * https://habrahabr.ru/post/129494/
 */
@CreationalPattern.Singleton
public class Singleton5_On_Demand_Holder_idiom {

    public static class SingletonHolder {
        public static final Singleton5_On_Demand_Holder_idiom HOLDER_INSTANCE = new Singleton5_On_Demand_Holder_idiom();
    }

    public static Singleton5_On_Demand_Holder_idiom getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }
}