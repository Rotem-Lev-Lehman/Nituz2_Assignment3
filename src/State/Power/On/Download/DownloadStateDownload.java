package State.Power.On.Download;

import State.Power.On.MyFile;
import State.Power.On.PowerStateOnMachine;

public class DownloadStateDownload extends ADownloadState {
    private Object lock;
    private Thread downloader;

    private double dataReceived;
    private double progress;
    private MyFile file;

    public DownloadStateDownload(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);

        lock = new Object();
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
        if(file!=null){
            dataReceived = Math.min(i, file.getSize());
            progress=dataReceived/file.getSize();
        }
        else
            progress=0;

        if(progress >= 1){
            downloadFinished();
        }
    }

    private void downloadFinished() {
        powerStateOnMachine.addSpace(-getFileSize());
        powerStateOnMachine.addPoint();
        powerStateOnMachine.addPoint();
        powerStateOnMachine.setCurrentDownloadState(powerStateOnMachine.getDownloadStateIdle());
    }

    @Override
    public void enterState() {
        super.enterState();
        if(!powerStateOnMachine.hasInternet()){
            powerStateOnMachine.setCurrentDownloadState(powerStateOnMachine.getDownloadStatePause());
        }
        else {
            synchronized (lock) {
                if (downloader != null && downloader.isAlive())
                    downloader.interrupt();

                downloader = new Thread(new myThread());
                downloader.start();
            }
        }
    }

    @Override
    public void exitState() {
        super.exitState();
        synchronized (lock) {
            if (downloader != null && downloader.isAlive()) {
                downloader.interrupt();
            }
        }
    }

    private void addChunk(){
        setDataReceived(dataReceived+powerStateOnMachine.getSpeed());
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

    @Override
    public void networkStateChanged(){
        if(!powerStateOnMachine.hasInternet())
            powerStateOnMachine.setCurrentDownloadState(powerStateOnMachine.getDownloadStatePause());
    }

    @Override
    public void downloadError() {
        powerStateOnMachine.setCurrentDownloadState(powerStateOnMachine.getDownloadStateRepair());
    }

    private class myThread implements Runnable{

        @Override
        public void run() {
            try {
                while (powerStateOnMachine.getCurrentDownloadState() == powerStateOnMachine.getDownloadStateDownload()) {
                    Thread.sleep(1000);
                    addChunk();
                }
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
    }

}
