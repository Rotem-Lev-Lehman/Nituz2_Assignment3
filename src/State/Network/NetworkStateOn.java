package State.Network;

import State.MovieDownloader;

public class NetworkStateOn extends ANetworkState{

    public NetworkStateOn(MovieDownloader movieDownloader) {
        super(movieDownloader);
    }

    @Override
    public String getStateName() {
        return (super.getStateName()+"_On");
    }

    @Override
    public void internetOff() {
        movieDownloader.setCurrentNetworkState(movieDownloader.getNetworkStateOff());
    }

}
