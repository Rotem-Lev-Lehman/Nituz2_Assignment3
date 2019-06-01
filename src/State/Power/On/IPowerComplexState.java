package State.Power.On;

import State.AComplexState;
import State.MovieDownloader;
import State.Power.IPowerState;

public abstract class IPowerComplexState extends AComplexState implements IPowerState {
    protected MovieDownloader movieDownloader;

    public IPowerComplexState(MovieDownloader movieDownloader) {
        this.movieDownloader = movieDownloader;
    }
}
