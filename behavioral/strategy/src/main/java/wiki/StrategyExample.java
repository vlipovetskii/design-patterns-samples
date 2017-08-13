package wiki;

/**
 * https://en.wikibooks.org/wiki/Computer_Science_Design_Patterns/Strategy
 *
 * Imports a type of lambdas taking two arguments of the same type T and returning one argument of same type T
 *
 */
import java.util.function.BinaryOperator;

/** Implements and assigns to variables the lambdas to be used later in configuring Context.
 *   FunctionalUtils is just a convenience class, as the code of a lambda
 *   might be passed directly to Context constructor, as for ResultD below, in main().
 */
class FunctionalUtils {
    static final BinaryOperator<Integer> add = (final Integer a, final Integer b) -> {
        System.out.println("Called add's apply().");
        return a + b;
    };

    static final BinaryOperator<Integer> subtract = (final Integer a, final Integer b) -> {
        System.out.println("Called subtract's apply().");
        return a - b;
    };

    static final BinaryOperator<Integer> multiply = (final Integer a, final Integer b) -> {
        System.out.println("Called multiply's apply().");
        return a * b;
    };
}

/** Configured with a lambda and maintains a reference to a lambda */
class Context {
    /** a variable referencing a lambda taking two Integer arguments and returning an Integer: */
    private final BinaryOperator<Integer> strategy;

    public Context(final BinaryOperator<Integer> lambda) {
        strategy = lambda;
    }

    public int executeStrategy(final int a, final int b) {
        return strategy.apply(a, b);
    }
}

/** Tests the pattern */
public class StrategyExample {

    public static void main(String[] args) {
        Context context;

        context = new Context(FunctionalUtils.add);
        final int resultA = context.executeStrategy(3,4);

        context = new Context(FunctionalUtils.subtract);
        final int resultB = context.executeStrategy(3, 4);

        context = new Context(FunctionalUtils.multiply);
        final int resultC = context.executeStrategy(3, 4);

        context = new Context((final Integer a, final Integer b) -> a * b + 1);
        final int resultD = context.executeStrategy(3,4);

        System.out.println("Result A: " + resultA );
        System.out.println("Result B: " + resultB );
        System.out.println("Result C: " + resultC );
        System.out.println("Result D: " + resultD );
    }
}