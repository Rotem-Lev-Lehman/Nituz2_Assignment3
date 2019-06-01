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

    @Override
    public void enterState() {
        super.enterState();
        if(powerStateOnMachine.getSpaceAvailable()>=powerStateOnMachine.getCurrentFileSize()){
            powerStateOnMachine.setCurrentDownloadState(powerStateOnMachine.getDownloadStateDownload());
        }
        else{
            powerStateOnMachine.setCurrentDownloadState(powerStateOnMachine.getDownloadStateSecondCheck());
        }
    }
}
