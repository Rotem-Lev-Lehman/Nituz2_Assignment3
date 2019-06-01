package State.Power.On.Queue;

import State.Power.On.PowerStateOn;
import State.Power.On.PowerStateOnMachine;

public abstract class AQueueState extends PowerStateOn {
    public AQueueState(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
    }
}
