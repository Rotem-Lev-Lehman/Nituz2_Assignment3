package State.Power.On.Queue;

import State.Power.On.PowerStateOn;
import State.Power.On.PowerStateOnMachine;

public abstract class IQueueState extends PowerStateOn {
    public IQueueState(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
    }
}
