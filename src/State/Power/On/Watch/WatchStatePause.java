package State.Power.On.Watch;

import State.Power.On.PowerStateOnMachine;

public class WatchStatePause extends AWatchState {
    public WatchStatePause(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
    }

    @Override
    public String getStateName() {
        return "Pause";
    }

    @Override
    public void resume() {
        powerStateOnMachine.setCurrentWatchState(powerStateOnMachine.getWatchStateWatch());
    }
}
