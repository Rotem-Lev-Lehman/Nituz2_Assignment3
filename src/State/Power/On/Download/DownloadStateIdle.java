package State.Power.On.Download;

import State.Power.On.PowerStateOnMachine;

public class DownloadStateIdle extends ADownloadState {
    public DownloadStateIdle(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
    }

    @Override
    public String getStateName() {
        return "Download_Idle";
    }

    @Override
    public void downloadAborted() { }
}
