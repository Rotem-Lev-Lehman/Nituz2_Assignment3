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

    @Override
    public void enterState() {
        super.enterState();
        //how to do tm(4) -> need to fix
        try {
            Thread.sleep(4000);
            if(powerStateOnMachine.getSpaceAvailable()>=powerStateOnMachine.getCurrentFileSize()){
                powerStateOnMachine.setCurrentDownloadState(powerStateOnMachine.getDownloadStateDownload());
            }
            else{
                powerStateOnMachine.setCurrentDownloadState(powerStateOnMachine.getDownloadStateIdle());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
