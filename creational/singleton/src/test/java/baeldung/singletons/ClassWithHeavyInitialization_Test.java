package baeldung.singletons;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * http://www.baeldung.com/kotlin-lazy-initialization
 */
public class ClassWithHeavyInitialization_Test {

    @Test
    public void giveHeavyClass_whenInitLazy_thenShouldReturnInstanceOnFirstCall() {
        // when
        ClassWithHeavyInitialization classWithHeavyInitialization
                = ClassWithHeavyInitialization.getInstance();
        ClassWithHeavyInitialization classWithHeavyInitialization2
                = ClassWithHeavyInitialization.getInstance();

        // then
        assertTrue(classWithHeavyInitialization == classWithHeavyInitialization2);
    }
}
