package State.Power.On.Watch;

import State.Power.On.PowerStateOn;
import State.Power.On.PowerStateOnMachine;

public abstract class IWatchState extends PowerStateOn {
    public IWatchState(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
    }
}
