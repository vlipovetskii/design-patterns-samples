package habrahabr.shalomman;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

/**
 * https://habrahabr.ru/post/27108/
 * В данном случае мы полностью решили проблему ленивой инициализации – объект инициализируется при первом вызове метода getInstance(). Но у нас осталась проблема с обработкой исключительных ситуаций в конструкторе. Так что, если конструктор класса не вызывает опасений создания исключительных ситуаций, то смело можно использовать этот метод.
 */
@CreationalPattern.Singleton
public class Singleton3 {

    private Singleton3() {
    }

    private static  class SingletonHolder {
        private static Singleton3 instance = new Singleton3();
    }


    public static Singleton3 getInstance() {
            return SingletonHolder.instance;
    }

}