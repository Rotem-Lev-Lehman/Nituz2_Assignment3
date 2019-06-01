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
}
