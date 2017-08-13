package dzone.dulajra;

/**
 * https://dzone.com/articles/java-singletons-using-enum
 * Copy of {@link dzone.dulajra.singletons.SingletonEnum} class with field variables
 * for demonstration purposes.
 *
 * @author Dulaj Atapattu
 */
public enum SingletonEnum {
    INSTANCE;

    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}