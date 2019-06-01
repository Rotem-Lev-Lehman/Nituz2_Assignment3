package State.Power.On;

import State.Power.APowerState;

public abstract class PowerStateOn extends APowerState {
    protected PowerStateOnMachine powerStateOnMachine;

    public PowerStateOn(PowerStateOnMachine powerStateOnMachine) {
        this.powerStateOnMachine = powerStateOnMachine;
    }
}
