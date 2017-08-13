package dzone.daveranjan;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

@CreationalPattern.Singleton
class Singleton {
    private static Singleton INSTANCE = null;
    private String criticalData;
    private Singleton() {
        criticalData = "This should be unique and state should be universal";
    }
    synchronized static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
    public String getString() {
        return this.criticalData;
    }
    public void setCriticalData(String value) {
        criticalData = value;
    }
}

