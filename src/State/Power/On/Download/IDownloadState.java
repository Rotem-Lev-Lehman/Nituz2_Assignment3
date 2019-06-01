package State.Power.On.Download;

import State.Power.On.PowerStateOn;
import State.Power.On.PowerStateOnMachine;

public abstract class IDownloadState extends PowerStateOn{
    public IDownloadState(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
    }
}
