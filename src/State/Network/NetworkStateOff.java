package State.Network;

import State.MovieDownloader;

public class NetworkStateOff extends ANetworkState{

    public NetworkStateOff(MovieDownloader movieDownloader) {
        super(movieDownloader);
    }

    @Override
    public String getStateName() {
        return (super.getStateName()+"_Off");
    }

    @Override
    public void internetOn() {
        movieDownloader.setCurrentNetworkState(movieDownloader.getNetworkStateOn());
    }


}
