package wiki;

interface IButton {
    void paint();
}

interface IGUIFactory {
    IButton createButton();
}

class WinFactory implements IGUIFactory {
    @Override
    public IButton createButton() {
        return new WinButton();
    }
}

class OSXFactory implements IGUIFactory {
    @Override
    public IButton createButton() {
        return new OSXButton();
    }
}

class WinButton implements IButton {
    @Override
    public void paint() {
        System.out.println("WinButton");
    }
}

class OSXButton implements IButton {
    @Override
    public void paint() {
        System.out.println("OSXButton");
    }
}

public class Main {

    public static void main(final String[] arguments) throws Exception {
        IGUIFactory factory;

        final String appearance = randomAppearance();	// Current operating system

        if (appearance.equals("OSX")) {
            factory = new OSXFactory();
        } else if(appearance.equals("Windows")) {
            factory = new WinFactory();
        } else {
            throw new Exception("No such operating system");
        }

        final IButton button = factory.createButton();

        button.paint();
    }

    /**
     * This is just for the sake of testing this program, and doesn't have to do
     * with Abstract Factory pattern.
     * @return -
     */
    static String randomAppearance() {
        final String[] appearanceArray = new String[3];

        appearanceArray[0] = "OSX";
        appearanceArray[1] = "Windows";
        appearanceArray[2] = "error";
        final java.util.Random random = new java.util.Random();

        final int randomNumber = random.nextInt(3);

        return appearanceArray[randomNumber];
    }
}