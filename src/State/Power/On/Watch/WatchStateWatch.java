package State.Power.On.Watch;

import State.Power.On.Download.ADownloadState;
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
        powerStateOnMachine.setSelfPause(true);
        powerStateOnMachine.setCurrentWatchState(powerStateOnMachine.getWatchStatePause());
    }

    @Override
    public void movieOff() {
        powerStateOnMachine.setCurrentWatchState(powerStateOnMachine.getWatchStateIdle());
    }

    @Override
    public void enterState(){
        super.enterState();
        checkPauseNeeded();
    }

    @Override
    public void downloadStateChanged(){
        super.downloadStateChanged();
        checkPauseNeeded();
    }

    private void checkPauseNeeded(){
        ADownloadState current=powerStateOnMachine.getCurrentDownloadState();
        if(current==powerStateOnMachine.getDownloadStateRepair() || current==powerStateOnMachine.getDownloadStatePause()){
            powerStateOnMachine.setSelfPause(false);
            powerStateOnMachine.setCurrentWatchState(powerStateOnMachine.getWatchStatePause());
        }
    }

}
