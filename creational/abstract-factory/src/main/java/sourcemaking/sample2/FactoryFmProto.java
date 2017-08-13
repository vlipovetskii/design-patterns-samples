package sourcemaking.sample2;

import vlfsoft.common.annotations.design.patterns.CreationalPattern;

class Expression implements Cloneable{
    public String str;

    public Expression(String str) {
        this.str = str;
    }

    @Override
    public Expression clone() {
        Expression clone = null;
        try {
            clone = (Expression)super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return clone;
    }

    @Override
    public String toString() {
        return str;
    }
}

@CreationalPattern.AbstractFactory
abstract class AbstractFactory {
    public Expression prototype;

    public Expression makePhase() {
        return prototype.clone();
    }

    public abstract Expression makeCompromise();

    public abstract Expression makeGrade();
}

@CreationalPattern.AbstractFactory
class PCFactory extends AbstractFactory {

    public PCFactory() {
        prototype = new PCPhase();
    }

    @Override
    public Expression makeCompromise() {
        return new Expression("\"do it your way, any way, or no way\"");
    }

    @Override
    public Expression makeGrade() {
        return new Expression("\"you pass, self-esteem intact\"");
    }
}

@CreationalPattern.AbstractFactory
class PCPhase extends Expression {
    private static int next = 0;
    private static final String[] list = {"\"animal companion\"", "\"vertically challenged\"",
            "\"factually inaccurate\"", "\"chronologically gifted\""};

    public PCPhase() {
        super(list[next]);
        next = (next + 1) % list.length;
    }

    @Override
    public Expression clone() {
        return new PCPhase();
    }
}

class NotPCPhase extends Expression {
    private static int next = 0;
    private static final String[] list = {"\"pet\"", "\"short\"", "\"lie\"", "\"old\""};

    public NotPCPhase() {
        super(list[next]);
        next = (next + 1) % list.length;
    }

    @Override
    public Expression clone() {
        return new NotPCPhase();
    }
}

class NotPCFactory extends AbstractFactory {

    public NotPCFactory() {
        prototype = new NotPCPhase();
    }

    @Override
    public Expression makeGrade() {
        return new Expression("\"my way, or the highway\"");
    }

    @Override
    public Expression makeCompromise() {
        return new Expression("\"take test, deal with the results\"");
    }
}

public class FactoryFmProto {
    public static void main(String[] args) {
        AbstractFactory factory;
        if (args.length  > 0) {
            factory = new PCFactory();
        } else {
            factory = new NotPCFactory();
        }
        for (int i = 0; i < 3; i++) {
            System.out.print(factory.makePhase() + " ");
        }
        System.out.println();
        System.out.println(factory.makeCompromise());
        System.out.println(factory.makeGrade());
    }
}
