package State.Power.On.Watch;

import State.Power.On.PowerStateOnMachine;

public class WatchStateWatch extends AWatchState {
    public WatchStateWatch(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
    }

    @Override
    public String getStateName() {
        return "Watch";
    }
}
