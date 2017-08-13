package dzone.vish;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

/**
 * @author Vishnu
 *
 */
@CreationalPattern.Singleton
public class StaticBlockSingleton {
	 private static StaticBlockSingleton instance;
     
	    private StaticBlockSingleton(){}
	     
	    static{
	        try{
	            instance = new StaticBlockSingleton();
	        }catch(Exception e){
	            throw new RuntimeException("Exception is occured in creating singleton instance");
	        }
	    }
	     
	    public static StaticBlockSingleton getInstance(){
	        return instance;
	    }
}
