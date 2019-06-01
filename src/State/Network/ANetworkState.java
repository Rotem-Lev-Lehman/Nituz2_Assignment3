package State.Network;

import State.IState;
import State.MovieDownloader;
import State.Power.On.MyFile;

public abstract class ANetworkState implements IState {
    protected MovieDownloader movieDownloader;

    public ANetworkState(MovieDownloader movieDownloader) {
        this.movieDownloader=movieDownloader;
    }

    @Override
    public String getStateName() {
        return "Network";
    }


    @Override
    public void turnOn() {

    }

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
    public void fileRequest(MyFile file) {

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
