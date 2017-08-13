package wiki;

/**
 * https://en.wikipedia.org/wiki/Command_pattern#Java
 */
import java.util.List;
import java.util.ArrayList;

/** The Command interface */
interface Command {
    void execute();
}

/** The Invoker class */
class Switch {
    private List<Command> history = new ArrayList<Command>();

    public void storeAndExecute(final Command cmd) {
        this.history.add(cmd); // optional
        cmd.execute();
    }
}

/** The Receiver class */
class Light {

    public void turnOn() {
        System.out.println("The light is on");
    }

    public void turnOff() {
        System.out.println("The light is off");
    }
}

/** The Command for turning on the light - ConcreteCommand #1 */
class FlipUpCommand implements Command {
    private Light theLight;

    public FlipUpCommand(final Light light) {
        this.theLight = light;
    }

    @Override    // Command
    public void execute() {
        theLight.turnOn();
    }
}

/** The Command for turning off the light - ConcreteCommand #2 */
class FlipDownCommand implements Command {
    private Light theLight;

    public FlipDownCommand(final Light light) {
        this.theLight = light;
    }

    @Override    // Command
    public void execute() {
        theLight.turnOff();
    }
}

/* The test class or client */
public class PressSwitch {
    public static void main(final String[] arguments){
        // Check number of arguments
        if (arguments.length != 1) {
            System.err.println("Argument \"ON\" or \"OFF\" is required.");
            System.exit(-1);
        }

        final Light lamp = new Light();

        final Command switchUp = new FlipUpCommand(lamp);
        final Command switchDown = new FlipDownCommand(lamp);

        final Switch mySwitch = new Switch();

        switch(arguments[0]) {
            case "ON":
                mySwitch.storeAndExecute(switchUp);
                break;
            case "OFF":
                mySwitch.storeAndExecute(switchDown);
                break;
            default:
                System.err.println("Argument \"ON\" or \"OFF\" is required.");
                System.exit(-1);
        }
    }
}

