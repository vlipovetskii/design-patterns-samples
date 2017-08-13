package dzone.dulajra.singletons;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

import java.io.Serializable;

/**
 * https://dzone.com/articles/java-singletons-using-enum
 * Deserialization safe singleton with public static final factory method.
 *
 * @author Dulaj Atapattu
 */
@CreationalPattern.Singleton
public class SingletonFieldSerializable implements Serializable{

    public static final SingletonFieldSerializable INSTANCE = new SingletonFieldSerializable();

    private SingletonFieldSerializable() {
    }

    protected Object readResolve() {
        return INSTANCE;
    }

}