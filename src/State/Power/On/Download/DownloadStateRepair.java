package State.Power.On.Download;

import State.Power.On.PowerStateOnMachine;

public class DownloadStateRepair extends ADownloadState {
    public DownloadStateRepair(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
    }

    @Override
    public String getStateName() {
        return "Repair";
    }

    @Override
    public void errorFixed() {
        powerStateOnMachine.setCurrentDownloadState(powerStateOnMachine.getDownloadStateDownload());
    }

    @Override
    public void enterState() {
        super.enterState();
        //how to do tm(3)
    }
}
