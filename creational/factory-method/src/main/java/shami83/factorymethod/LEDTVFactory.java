package shami83.factorymethod;

/**
 * @author Shamik Mitra
 *
 */
interface ITV {
    public void createTV();
}

/**
 * @author Shamik Mitra
 *
 */
abstract class AbstractFactory {
    public final void orderTV() {
        createTV();
        int charge= shippingCharge();
        System.out.println("Shipping charge :: " + charge + " INR");
    }
    protected abstract int shippingCharge();
    protected abstract void createTV();
}

/**
 * @author Shamik Mitra
 *
 */
public class LEDTVFactory extends AbstractFactory {
    @Override
    public int shippingCharge() {
        // TODO Auto-generated method stub
        return 1000;
    }
    @Override
    public void createTV() {
        new ITV() {
            @Override
            public void createTV() {
                System.out.println("LED TV");
            }
        }.createTV();
    }
    public static void main(String[] args) {
        AbstractFactory factory = new LEDTVFactory();
        factory.orderTV();
    }
}