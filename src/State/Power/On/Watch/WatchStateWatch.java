package State.Power.On.Watch;

import State.Power.On.Download.ADownloadState;
import State.Power.On.PowerStateOnMachine;

public class WatchStateWatch extends AWatchState {
    private Object lock;
    private Thread moviePlayer;

    private volatile double time;

    public WatchStateWatch(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
        lock = new Object();
    }

    @Override
    public String getStateName() {
        return "Watch";
    }

    public void resetTime(){
        time=0;
    }

    @Override
    public void restartMovie() {
        resetTime();
    }

    @Override
    public void holdMovie() {
        powerStateOnMachine.setSelfPause(true);
        powerStateOnMachine.setCurrentWatchState(powerStateOnMachine.getWatchStatePause());
    }

    @Override
    public void movieOff() {
        powerStateOnMachine.setCurrentWatchState(powerStateOnMachine.getWatchStateIdle());
    }

    @Override
    public void enterState(){
        super.enterState();
        if(!checkPauseNeeded()){
            synchronized (lock) {
                if (moviePlayer != null && moviePlayer.isAlive())
                    moviePlayer.interrupt();

                moviePlayer = new Thread(new myThread());
                moviePlayer.start();
            }
        }
    }

    @Override
    public void exitState() {
        super.exitState();
        synchronized (lock) {
            if (moviePlayer != null && moviePlayer.isAlive()) {
                moviePlayer.interrupt();
            }
        }
    }

    @Override
    public void downloadStateChanged(){
        super.downloadStateChanged();
        checkPauseNeeded();
    }

    private boolean checkPauseNeeded(){
        ADownloadState current=powerStateOnMachine.getCurrentDownloadState();
        if(current==powerStateOnMachine.getDownloadStateRepair() || current==powerStateOnMachine.getDownloadStatePause()){
            powerStateOnMachine.setSelfPause(false);
            powerStateOnMachine.setCurrentWatchState(powerStateOnMachine.getWatchStatePause());
            return true;
        }
        return false;
    }

    public double getTime() {
        return time;
    }

    private class myThread implements Runnable{

        @Override
        public void run() {
            try {
                while (powerStateOnMachine.getCurrentWatchState() == powerStateOnMachine.getWatchStateWatch()) {
                    Thread.sleep(1000);
                    play(time);
                    time++;
                }
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
    }

    private void play(double time) {
        //playing :)
    }

}
