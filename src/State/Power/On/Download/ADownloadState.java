package State.Power.On.Download;

import State.Power.On.PowerStateOn;
import State.Power.On.PowerStateOnMachine;

public abstract class ADownloadState extends PowerStateOn{
    public ADownloadState(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
    }

    @Override
    public void downloadAborted() {
        powerStateOnMachine.setCurrentDownloadState(powerStateOnMachine.getDownloadStateIdle());
    }

    public void fileAdded(){}

}
