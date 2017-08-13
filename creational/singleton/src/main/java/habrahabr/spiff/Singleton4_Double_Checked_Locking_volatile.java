package habrahabr.spiff;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

/**
 * https://habrahabr.ru/post/129494/
 */
@CreationalPattern.Singleton
public class Singleton4_Double_Checked_Locking_volatile {
    private static volatile Singleton4_Double_Checked_Locking_volatile instance;

    public static Singleton4_Double_Checked_Locking_volatile getInstance() {
        Singleton4_Double_Checked_Locking_volatile localInstance = instance;
        if (localInstance == null) {
            synchronized (Singleton4_Double_Checked_Locking_volatile.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Singleton4_Double_Checked_Locking_volatile();
                }
            }
        }
        return localInstance;
    }
}