package dzone.vish;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

import java.io.Serializable;

/**
 * @author Vishnu
 *
 */
@CreationalPattern.Singleton
public class SerializedSingleton implements Serializable{
	private static final long serialVersionUID = -7604766932017737115L;
	 
    private SerializedSingleton(){}
     
    private static class SingletonHelper{
        private static final SerializedSingleton instance = new SerializedSingleton();
    }
     
    public static SerializedSingleton getInstance(){
        return SingletonHelper.instance;
    }
    protected Object readResolve() {
        return SingletonHelper.instance;
    }
   
}
