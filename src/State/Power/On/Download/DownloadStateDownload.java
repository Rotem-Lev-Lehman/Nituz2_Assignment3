package State.Power.On.Download;

import State.Power.On.MyFile;
import State.Power.On.PowerStateOnMachine;

public class DownloadStateDownload extends ADownloadState {
    private double dataReceived;
    private double progress;
    private MyFile file;

    public DownloadStateDownload(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
    }

    @Override
    public String getStateName() {
        return "Download";
    }

    public double getProgress() {
        return progress;
    }

    public void resetData(){
        setDataReceived(0);
        file=null;
    }

    private void setDataReceived(double i) {
        dataReceived=i;
        if(file!=null){
            progress=i/file.getSize();
        }
        else
            progress=0;
    }

    private void addChunk(double chunk){
        setDataReceived(dataReceived+chunk);
    }

    public MyFile getFile() {
        return file;
    }

    public void setFile(MyFile file) {
        this.file = file;
    }

    public double getFileSize() {
        return file.getSize();
    }

    public void internetOff(){
        powerStateOnMachine.setCurrentDownloadState(powerStateOnMachine.getDownloadStatePause());
    }

    public void enterState(){
        super.enterState();
        if(powerStateOnMachine.getMovieDownloader().getCurrentNetworkState()==powerStateOnMachine.getMovieDownloader().getNetworkStateOff()){
            powerStateOnMachine.setCurrentDownloadState(powerStateOnMachine.getDownloadStatePause());
        }
    }

    @Override
    public void downloadError() {
        powerStateOnMachine.setCurrentDownloadState(powerStateOnMachine.getDownloadStateRepair());
    }


}
