package State.Power.On.Watch;

import State.Power.On.Download.ADownloadState;
import State.Power.On.PowerStateOnMachine;

public class WatchStatePause extends AWatchState {
    private boolean selfPause;

    public WatchStatePause(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
    }

    @Override
    public String getStateName() {
        return "Pause";
    }

    @Override
    public void resume() {
        if(selfPause){
            powerStateOnMachine.setCurrentWatchState(powerStateOnMachine.getWatchStateWatch());
        }
    }

    public void setSelfPause(boolean selfPause) {
        this.selfPause = selfPause;
    }

    @Override
    public void enterState(){
        super.enterState();
        checkResumeNeeded();
    }

    @Override
    public void downloadStateChanged(){
        super.downloadStateChanged();
        checkResumeNeeded();
    }

    private void checkResumeNeeded(){
        ADownloadState current=powerStateOnMachine.getCurrentDownloadState();
        if(current==powerStateOnMachine.getDownloadStateDownload() && !selfPause){
            powerStateOnMachine.setCurrentWatchState(powerStateOnMachine.getWatchStateWatch());
        }
    }
}
