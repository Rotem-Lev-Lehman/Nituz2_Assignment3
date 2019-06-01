package State.Power.On.AccountType;

import State.Power.On.PowerStateOnMachine;

public class AccountTypeStateAdvanced extends AAccountTypeState {
    public AccountTypeStateAdvanced(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
    }

    @Override
    public void pointsChanged() {
        int points=powerStateOnMachine.getPoints();
        if(points<4){
            powerStateOnMachine.setCurrentAccountTypeState(powerStateOnMachine.getAccountTypeStateStarter());
        }
        else if(points>=7){
            powerStateOnMachine.setCurrentAccountTypeState(powerStateOnMachine.getAccountTypeStateProfessional());
        }
    }

    @Override
    public void setSpeed() {
        powerStateOnMachine.setSpeed(1.2);
    }

    @Override
    public String getStateName() {
        return "Advanced";
    }

}
