package State.Power.On.AccountType;

import State.Power.On.PowerStateOn;
import State.Power.On.PowerStateOnMachine;

public abstract class IAccountTypeState extends PowerStateOn {
    public IAccountTypeState(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
    }
}
