package State.Power.On.Download;

import State.Power.On.PowerStateOnMachine;

public class DownloadStateRepair extends ADownloadState {
    private Object lock;
    private Thread waitForRepair;

    public DownloadStateRepair(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
        lock = new Object();
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

        synchronized (lock) {
            if (waitForRepair != null && waitForRepair.isAlive())
                waitForRepair.interrupt();

            waitForRepair = new Thread(new myThread());
            waitForRepair.start();
        }
    }

    @Override
    public void exitState() {
        super.exitState();
        synchronized (lock) {
            if (waitForRepair != null && waitForRepair.isAlive()) {
                waitForRepair.interrupt();
            }
        }
    }

    private class myThread implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                if(powerStateOnMachine.getCurrentDownloadState() == powerStateOnMachine.getDownloadStateRepair()) {
                    powerStateOnMachine.setCurrentDownloadState(powerStateOnMachine.getDownloadStateIdle());
                }
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
    }
}
