package dzone.vish;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

/**
 * @author Vishnu
 *
 */
@CreationalPattern.Singleton
public class ThreadSafeSingleton {
	 private static ThreadSafeSingleton instance;
     
	    private ThreadSafeSingleton(){}
	     
	    public static ThreadSafeSingleton getInstance(){
	        if(instance == null){
	            synchronized (ThreadSafeSingleton.class) {
	            instance = new ThreadSafeSingleton();
	          }
	        }
	        return instance;
	    }
}
