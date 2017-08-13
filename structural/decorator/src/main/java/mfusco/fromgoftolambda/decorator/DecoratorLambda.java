package mfusco.fromgoftolambda.decorator;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.Stream;

/**
 * http://data-structure-learning.blogspot.com/2015/07/java-lambda-doubleunaryoperator.html
 * http://www.java2s.com/Tutorials/Java/java.util.function/DoubleUnaryOperator/index.htm
 */
public class DecoratorLambda {

    public static class DefaultSalaryCalculator implements DoubleUnaryOperator {
        @Override
        public double applyAsDouble( double grossAnnual ) {
            return grossAnnual / 12;
        }
    }

    public static void main( String[] args ) {
        new DefaultSalaryCalculator()
                .andThen( Taxes::generalTax )
                .andThen( Taxes::regionalTax )
                .andThen( Taxes::healthInsurance )
                .applyAsDouble( 80000.00 );

        calculateSalary( 80000.00, new DefaultSalaryCalculator(), Taxes::generalTax, Taxes::regionalTax, Taxes::healthInsurance );
    }

    public static double calculateSalary(double annualGross, DoubleUnaryOperator... taxes) {
        return Stream.of(taxes).reduce( DoubleUnaryOperator.identity(), DoubleUnaryOperator::andThen ).applyAsDouble( annualGross );
    }
}
