package dzone.dulajra;

import java.io.Serializable;

/**
 * https://dzone.com/articles/java-singletons-using-enum
 * Copy of {@link dzone.dulajra.singletons.SingletonField} class with field variables
 * for demonstration purposes.
 *
 * @author Dulaj Atapattu
 */
public class Singleton implements Serializable{

    public static final Singleton INSTANCE = new Singleton();

    private int value = 0;

    private Singleton() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
