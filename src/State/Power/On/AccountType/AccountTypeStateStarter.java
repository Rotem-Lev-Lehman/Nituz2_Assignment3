package State.Power.On.AccountType;

import State.Power.On.PowerStateOnMachine;

public class AccountTypeStateStarter extends AAccountTypeState {
    public AccountTypeStateStarter(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
    }

    @Override
    public String getStateName() {
        return "Starter";
    }

    @Override
    public void pointsChanged() {
        int points=powerStateOnMachine.getPoints();
        if(points>=4){
            powerStateOnMachine.setCurrentAccountTypeState(powerStateOnMachine.getAccountTypeStateAdvanced());
        }
    }

    @Override
    public void setSpeed() {
        powerStateOnMachine.setSpeed(1);
    }
}
