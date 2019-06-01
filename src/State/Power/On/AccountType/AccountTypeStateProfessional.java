package State.Power.On.AccountType;

import State.Power.On.PowerStateOnMachine;

public class AccountTypeStateProfessional extends AAccountTypeState {
    public AccountTypeStateProfessional(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
    }

    @Override
    public String getStateName() {
        return "Professional";
    }

    @Override
    public void pointsChanged() {
        int points=powerStateOnMachine.getPoints();
        if(points<7){
            powerStateOnMachine.setCurrentAccountTypeState(powerStateOnMachine.getAccountTypeStateAdvanced());
        }
    }

    @Override
    public void setSpeed() {
        powerStateOnMachine.setSpeed(1.5);
    }
}
