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

    @Override
    public void enterState() {
        super.enterState();
        powerStateOnMachine.removePoint();
        powerStateOnMachine.resetData();
        checkFileWaits();
    }

    private void checkFileWaits() {
        if(powerStateOnMachine.fileWaits()){
            powerStateOnMachine.getNext();
            powerStateOnMachine.setCurrentDownloadState(powerStateOnMachine.getDownloadStateFirstCheck());
        }
    }

    public void fileAdded(){
        checkFileWaits();
    }

}
