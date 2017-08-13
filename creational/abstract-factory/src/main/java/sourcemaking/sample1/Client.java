package sourcemaking.sample1;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

// class CPU
abstract class CPU {}

// class EmberCPU
class EmberCPU extends CPU {}

// class EnginolaCPU
class EnginolaCPU extends CPU {}

// class MMU
abstract class MMU {}

// class EmberMMU
class EmberMMU extends MMU {}

// class EnginolaMMU
class EnginolaMMU extends MMU {}

// class EmberFactory
@CreationalPattern.AbstractFactory
class EmberToolkit extends AbstractFactory {
    @Override
    public CPU createCPU() {
        return new EmberCPU();
    }

    @Override
    public MMU createMMU() {
        return new EmberMMU();
    }
}

// class EnginolaFactory
@CreationalPattern.AbstractFactory
class EnginolaToolkit extends AbstractFactory {
    @Override
    public CPU createCPU() {
        return new EnginolaCPU();
    }

    @Override
    public MMU createMMU() {
        return new EnginolaMMU();
    }
}

enum Architecture {
    ENGINOLA, EMBER
}

@CreationalPattern.AbstractFactory
abstract class AbstractFactory {
    private static final EmberToolkit EMBER_TOOLKIT = new EmberToolkit();
    private static final EnginolaToolkit ENGINOLA_TOOLKIT = new EnginolaToolkit();

    // Returns a concrete factory object that is an instance of the
    // concrete factory class appropriate for the given architecture.
    static AbstractFactory getFactory(Architecture architecture) {
        AbstractFactory factory = null;
        switch (architecture) {
            case ENGINOLA:
                factory = ENGINOLA_TOOLKIT;
            case EMBER:
                factory = EMBER_TOOLKIT;
        }
        return factory;
    }

    public abstract CPU createCPU();

    public abstract MMU createMMU();
}

public class Client {
    public static void main(String[] args) {
        AbstractFactory factory = AbstractFactory.getFactory(Architecture.EMBER);
        CPU cpu = factory.createCPU();
    }
}
