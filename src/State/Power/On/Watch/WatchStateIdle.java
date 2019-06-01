package State.Power.On.Watch;

import State.Power.On.PowerStateOnMachine;

public class WatchStateIdle extends AWatchState {
    public WatchStateIdle(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
    }

    @Override
    public String getStateName() {
        return "Watch_Idle";
    }
}
