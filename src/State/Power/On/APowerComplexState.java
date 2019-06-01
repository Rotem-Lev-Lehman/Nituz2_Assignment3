package State.Power.On;

import State.AComplexState;
import State.MovieDownloader;
import State.Power.IPowerState;

public abstract class APowerComplexState extends AComplexState implements IPowerState {
    protected MovieDownloader movieDownloader;

    public APowerComplexState(MovieDownloader movieDownloader) {
        this.movieDownloader = movieDownloader;
    }

    public MovieDownloader getMovieDownloader() {
        return movieDownloader;
    }
}
