package State.Power.On.Watch;

import State.Power.On.PowerStateOnMachine;

public class WatchStateWatch extends AWatchState {
    private double time;

    public WatchStateWatch(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
    }

    @Override
    public String getStateName() {
        return "Watch";
    }

    public void resetTime(){
        time=0;
    }

    @Override
    public void restartMovie() {
        resetTime();
    }

    @Override
    public void holdMovie() {
        powerStateOnMachine.setCurrentWatchState(powerStateOnMachine.getWatchStatePause());
    }

    @Override
    public void movieOff() {
        powerStateOnMachine.setCurrentWatchState(powerStateOnMachine.getWatchStateIdle());
    }
}
