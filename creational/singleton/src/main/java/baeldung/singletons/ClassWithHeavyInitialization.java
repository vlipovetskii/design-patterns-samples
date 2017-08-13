package baeldung.singletons;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

/**
 * http://www.baeldung.com/kotlin-lazy-initialization
 */
@CreationalPattern.Singleton
public class ClassWithHeavyInitialization {

    private ClassWithHeavyInitialization() {
    }

    private static class LazyHolder {
        public static final ClassWithHeavyInitialization INSTANCE = new ClassWithHeavyInitialization();
    }

    public static ClassWithHeavyInitialization getInstance() {
        return LazyHolder.INSTANCE;
    }
}
