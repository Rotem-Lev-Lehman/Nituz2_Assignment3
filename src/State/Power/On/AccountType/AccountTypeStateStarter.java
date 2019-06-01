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
}
