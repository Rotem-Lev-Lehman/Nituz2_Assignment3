package State.Power.On.Download;

import State.Power.On.PowerStateOnMachine;

public class DownloadStateSecondCheck extends ADownloadState {
    private Thread secondCheckThread;
    private Object lock;
    private volatile boolean needToCheck;

    public DownloadStateSecondCheck(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
        lock = new Object();
        secondCheckThread = null;
    }

    @Override
    public String getStateName() {
        return "Second_Check";
    }

    @Override
    public void enterState() {
        super.enterState();

        synchronized (lock) {
            if (secondCheckThread != null && secondCheckThread.isAlive()) {
                secondCheckThread.interrupt();
            }
            needToCheck = true;
            secondCheckThread = new Thread(new myThread());
            secondCheckThread.start();
        }
    }

    public void setNeedToCheck(boolean bool){
        needToCheck = bool;
        if(!needToCheck){
            synchronized (lock) {
                if (secondCheckThread != null && secondCheckThread.isAlive()) {
                    secondCheckThread.interrupt();
                }
            }
        }
    }

    private class myThread implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(4000);
                if(needToCheck) {
                    if (powerStateOnMachine.getSpaceAvailable() >= powerStateOnMachine.getCurrentFileSize()) {
                        powerStateOnMachine.setCurrentDownloadState(powerStateOnMachine.getDownloadStateDownload());
                    } else {
                        powerStateOnMachine.setCurrentDownloadState(powerStateOnMachine.getDownloadStateIdle());
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
