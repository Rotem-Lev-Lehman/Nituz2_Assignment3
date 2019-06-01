package State.Power.On.Download;

import State.Power.On.PowerStateOnMachine;

public class DownloadStateFirstCheck extends ADownloadState {
    public DownloadStateFirstCheck(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
    }

    @Override
    public String getStateName() {
        return "First_Check";
    }
}
