package dzone.vish;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

/**
 * @author Vishnu
 *
 */
@CreationalPattern.Singleton
public class EagerSingleton {
	private static  EagerSingleton instance = new EagerSingleton();
	 
    private EagerSingleton() {
    }
 
    /**
     * @return
     */
    public static EagerSingleton getInstance() {
        return instance;
    }
}
