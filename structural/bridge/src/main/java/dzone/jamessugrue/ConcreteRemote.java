package dzone.jamessugrue;

import vlfsoft.common.annotations.design.patterns.StructuralPattern;

@StructuralPattern.Bridge
//Implementor
interface TV {
    public void on();

    public void off();

    public void tuneChannel(int channel);
}

//Concrete Implementor
class Sony implements TV {

    public void on() {
        //Sony specific on
    }

    public void off() {
        //Sony specific off
    }

    public void tuneChannel(int channel) {
        //Sony specific tuneChannel}
    }

}

//Concrete Implementor
class Philips implements TV {
    public void on() {
    }

    //Philips specific on
    public void off() {
        //Philips specific off
    }

    public void tuneChannel(int channel) {
        //Philips specific tuneChannel
    }

}

//Abstraction
abstract class RemoteControl {
    private TV implementor;

    public void on() {
        implementor.on();
    }

    public void off() {
        implementor.off();
    }

    public void setChannel(int channel) {
        implementor.tuneChannel(channel);
    }
}

// Refined abstraction
public class ConcreteRemote extends RemoteControl {
    private int currentChannel;

    public void nextChannel() {
        currentChannel++;
        setChannel(currentChannel);
    }

    public void prevChannel() {
        currentChannel--;
        setChannel(currentChannel);
    }
}

