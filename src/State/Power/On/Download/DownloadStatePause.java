package State.Power.On.Download;

import State.Power.On.PowerStateOnMachine;

public class DownloadStatePause extends ADownloadState {
    public DownloadStatePause(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
    }

    @Override
    public String getStateName() {
        return "Download_Pause";
    }
}
