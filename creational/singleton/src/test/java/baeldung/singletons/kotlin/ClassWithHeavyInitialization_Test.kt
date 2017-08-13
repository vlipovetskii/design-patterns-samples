package baeldung.singletons.kotlin

import org.junit.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import kotlin.test.assertEquals

/**
 * http://www.baeldung.com/kotlin-lazy-initialization
 */
class ClassWithHeavyInitialization_Test {

    @Test
    fun givenLazyValue_whenGetIt_thenShouldInitializeItOnlyOnce() {
        // given
        val numberOfInitializations: AtomicInteger = AtomicInteger()
        val lazyValue: ClassWithHeavyInitialization by lazy {
            numberOfInitializations.incrementAndGet()
            ClassWithHeavyInitialization()
        }
        // when
        println(lazyValue)
        println(lazyValue)

        // then
        assertEquals(numberOfInitializations.get(), 1)
    }

    /**
     * When {@link #whenGetItUsingPublication_thenCouldInitializeItMoreThanOnce} is launched itself it works correctly
     * When {@link #whenGetItUsingPublication_thenCouldInitializeItMoreThanOnce} is launched as simultaneously with other tests in the class, it works incorrectly
     */
    @Test
    fun whenGetItUsingPublication_thenCouldInitializeItMoreThanOnce() {

        // given
        val numberOfInitializations: AtomicInteger = AtomicInteger()
        val lazyValue: ClassWithHeavyInitialization
                by lazy(LazyThreadSafetyMode.PUBLICATION) {
                    numberOfInitializations.incrementAndGet()
                    ClassWithHeavyInitialization()
                }
        val executorService = Executors.newFixedThreadPool(2)

        // http://tutorials.jenkov.com/java-util-concurrent/countdownlatch.html
        val countDownLatch = CountDownLatch(1)

        // when
        executorService.submit { countDownLatch.await(); println(lazyValue) }
        executorService.submit { countDownLatch.await(); println(lazyValue) }
        countDownLatch.countDown()

        // then
        executorService.awaitTermination(1, TimeUnit.SECONDS)
        executorService.shutdown()
        assertEquals(numberOfInitializations.get(), 2)
    }

    lateinit var a: String

    @Test
    fun givenLateInitProperty_whenAccessItAfterInit_thenPass() {
        // when
        a = "it"
        println(a)

        // then not throw
    }

    @Test(expected = UninitializedPropertyAccessException::class)
    fun givenLateInitProperty_whenAccessItWithoutInit_thenThrow() {
        // when
        println(a)
    }
}