package State;

import java.util.LinkedList;
import java.util.List;

public abstract class AComplexState implements IState{
    protected List<IState> currentStates;

    public AComplexState() {
        this.currentStates = new LinkedList<>();
    }

    @Override
    public void turnOn() {
        for(IState state : currentStates)
            state.turnOn();
    }

    @Override
    public void turnOff() {
        for(IState state : currentStates)
            state.turnOff();
    }

    @Override
    public void internetOn() {
        for(IState state : currentStates)
            state.internetOn();
    }

    @Override
    public void internetOff() {
        for(IState state : currentStates)
            state.internetOff();
    }

    @Override
    public void fileRequest() {
        for(IState state : currentStates)
            state.fileRequest();
    }

    @Override
    public void downloadAborted() {
        for(IState state : currentStates)
            state.downloadAborted();
    }

    @Override
    public void downloadError() {
        for(IState state : currentStates)
            state.downloadError();
    }

    @Override
    public void errorFixed() {
        for(IState state : currentStates)
            state.errorFixed();
    }

    @Override
    public void movieOn() {
        for(IState state : currentStates)
            state.movieOn();
    }

    @Override
    public void restartMovie() {
        for(IState state : currentStates)
            state.restartMovie();
    }

    @Override
    public void holdMovie() {
        for(IState state : currentStates)
            state.holdMovie();
    }

    @Override
    public void movieOff() {
        for(IState state : currentStates)
            state.movieOff();
    }

    @Override
    public void resume() {
        for(IState state : currentStates)
            state.resume();
    }
}
