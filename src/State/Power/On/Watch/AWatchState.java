package State.Power.On.Watch;

import State.Power.On.PowerStateOn;
import State.Power.On.PowerStateOnMachine;

public abstract class AWatchState extends PowerStateOn {
    public AWatchState(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
    }
}
