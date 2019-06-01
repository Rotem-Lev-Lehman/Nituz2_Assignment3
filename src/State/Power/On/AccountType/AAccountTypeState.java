package State.Power.On.AccountType;

import State.Power.On.PowerStateOn;
import State.Power.On.PowerStateOnMachine;

public abstract class AAccountTypeState extends PowerStateOn {
    public AAccountTypeState(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
    }

    public abstract void pointsChanged();
    public abstract void setSpeed();

    public void enterState(){

        super.enterState();
        setSpeed();
    }
}
