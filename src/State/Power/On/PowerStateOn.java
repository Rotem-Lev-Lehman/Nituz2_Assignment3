package State.Power.On;

import State.IState;
import State.Power.IPowerState;

public abstract class PowerStateOn implements IPowerState {
    protected PowerStateOnMachine powerStateOnMachine;

    public PowerStateOn(PowerStateOnMachine powerStateOnMachine) {
        this.powerStateOnMachine = powerStateOnMachine;
    }

    protected void printExit() {
        System.out.println("exit " + getStateName() + " state");
    }

    protected void printEnter() {
        System.out.println("enter " + getStateName() + " state");
    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public void internetOn() {

    }

    @Override
    public void internetOff() {

    }

    @Override
    public void fileRequest() {

    }

    @Override
    public void downloadAborted() {

    }

    @Override
    public void downloadError() {

    }

    @Override
    public void errorFixed() {

    }

    @Override
    public void movieOn() {

    }

    @Override
    public void restartMovie() {

    }

    @Override
    public void holdMovie() {

    }

    @Override
    public void movieOff() {

    }

    @Override
    public void resume() {

    }
}
