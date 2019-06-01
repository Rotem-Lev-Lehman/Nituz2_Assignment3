package State.Power.Off;

import State.MovieDownloader;
import State.Power.IPowerState;

public class PowerStateOff implements IPowerState {
    private MovieDownloader movieDownloader;

    public PowerStateOff(MovieDownloader movieDownloader) {
        this.movieDownloader = movieDownloader;
    }

    @Override
    public String getStateName() {
        return "Off";
    }

    @Override
    public void turnOn() {
        if(movieDownloader.getCurrentNetworkState()==movieDownloader.getNetworkStateOn()){
            movieDownloader.setCurrentPowerState(movieDownloader.getPowerStateOnMachine());
        }
    }

    //useless

    @Override
    public void turnOff() {

    }

    @Override
    public void internetOn() {

    }

    @Override
    public void internetOff() {

    }

    @Override
    public void fileRequest() {

    }

    @Override
    public void downloadAborted() {

    }

    @Override
    public void downloadError() {

    }

    @Override
    public void errorFixed() {
    }

    @Override
    public void movieOn() {
    }

    @Override
    public void restartMovie() {
    }

    @Override
    public void holdMovie() {
    }

    @Override
    public void movieOff() {
    }

    @Override
    public void resume() {
    }
}
