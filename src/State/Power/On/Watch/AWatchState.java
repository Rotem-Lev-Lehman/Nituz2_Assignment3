package State.Power.On.Watch;

import State.Power.On.Download.ADownloadState;
import State.Power.On.PowerStateOn;
import State.Power.On.PowerStateOnMachine;

public abstract class AWatchState extends PowerStateOn {
    public AWatchState(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
    }

    public void enterState(){
        super.enterState();
        checkDownloadIdle();
    }

    public void downloadStateChanged(){
        checkDownloadIdle();
    }

    private void checkDownloadIdle(){
        ADownloadState current=powerStateOnMachine.getCurrentDownloadState();
        if(powerStateOnMachine.getCurrentWatchState()!=powerStateOnMachine.getWatchStateIdle() && current==powerStateOnMachine.getDownloadStateIdle()){
            powerStateOnMachine.setCurrentWatchState(powerStateOnMachine.getWatchStateIdle());
        }
    }
}
