package dzone.vish;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

/**
 * @author Vishnu
 *
 */
@CreationalPattern.Singleton
public enum EnumSinleton {
	INSTANCE;
    public void someMethod(String param) {
        // some class member
    }
}
