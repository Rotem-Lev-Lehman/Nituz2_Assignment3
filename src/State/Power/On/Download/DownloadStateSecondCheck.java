package State.Power.On.Download;

import State.Power.On.PowerStateOnMachine;

public class DownloadStateSecondCheck extends ADownloadState {
    public DownloadStateSecondCheck(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
    }

    @Override
    public String getStateName() {
        return "Second_Check";
    }
}
