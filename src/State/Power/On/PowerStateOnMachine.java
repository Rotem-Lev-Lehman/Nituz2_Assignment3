package State.Power.On;

import State.IState;
import State.Power.APowerState;
import State.Power.On.AccountType.*;
import State.Power.On.Download.*;
import State.Power.On.Queue.*;
import State.Power.On.Watch.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PowerStateOnMachine extends APowerState {
    private List<PowerStateOn> currentStates;

    private AWatchState currentWatchState;
    private WatchStateIdle watchStateIdle;
    private WatchStatePause watchStatePause;
    private WatchStateWatch watchStateWatch;

    private ADownloadState currentDownloadState;
    private DownloadStateDownload downloadStateDownload;
    private DownloadStateFirstCheck downloadStateFirstCheck;
    private DownloadStateSecondCheck downloadStateSecondCheck;
    private DownloadStateIdle downloadStateIdle;
    private DownloadStatePause downloadStatePause;
    private DownloadStateRepair downloadStateRepair;

    private AAccountTypeState currentAccountTypeState;
    private AccountTypeStateAdvanced accountTypeStateAdvanced;
    private AccountTypeStateProfessional accountTypeStateProfessional;
    private AccountTypeStateStarter accountTypeStateStarter;

    private AQueueState currentQueueState;
    private QueueStateManager queueStateManager;

    public PowerStateOnMachine() {
        this.currentStates = new ArrayList<>();

        this.watchStateIdle = new WatchStateIdle();
        this.watchStatePause = new WatchStatePause();
        this.watchStateWatch = new WatchStateWatch();
        this.currentWatchState = watchStateIdle;
        currentStates.add(currentWatchState);

        this.downloadStateDownload = new DownloadStateDownload();
        this.downloadStateFirstCheck = new DownloadStateFirstCheck();
        this.downloadStateSecondCheck = new DownloadStateSecondCheck();
        this.downloadStateIdle = new DownloadStateIdle();
        this.downloadStatePause = new DownloadStatePause();
        this.downloadStateRepair = new DownloadStateRepair();
        this.currentDownloadState = downloadStateIdle;
        currentStates.add(currentDownloadState);

        this.accountTypeStateAdvanced = new AccountTypeStateAdvanced();
        this.accountTypeStateProfessional = new AccountTypeStateProfessional();
        this.accountTypeStateStarter = new AccountTypeStateStarter();
        this.currentAccountTypeState = accountTypeStateStarter;
        currentStates.add(currentAccountTypeState);

        this.queueStateManager = new QueueStateManager();
        this.currentQueueState = queueStateManager;
        currentStates.add(currentQueueState);
    }

    @Override
    public void turnOn() {
        for(PowerStateOn state : currentStates)
            state.turnOn();
    }

    @Override
    public void turnOff() {
        for(PowerStateOn state : currentStates)
            state.turnOff();
    }

    @Override
    public void internetOn() {
        for(PowerStateOn state : currentStates)
            state.internetOn();
    }

    @Override
    public void internetOff() {
        for(PowerStateOn state : currentStates)
            state.internetOff();
    }

    @Override
    public void fileRequest() {
        for(PowerStateOn state : currentStates)
            state.fileRequest();
    }

    @Override
    public void downloadAborted() {
        for(PowerStateOn state : currentStates)
            state.downloadAborted();
    }

    @Override
    public void downloadError() {
        for(PowerStateOn state : currentStates)
            state.downloadError();
    }

    @Override
    public void errorFixed() {
        for(PowerStateOn state : currentStates)
            state.errorFixed();
    }

    @Override
    public void movieOn() {
        for(PowerStateOn state : currentStates)
            state.movieOn();
    }

    @Override
    public void restartMovie() {
        for(PowerStateOn state : currentStates)
            state.restartMovie();
    }

    @Override
    public void holdMovie() {
        for(PowerStateOn state : currentStates)
            state.holdMovie();
    }

    @Override
    public void movieOff() {
        for(PowerStateOn state : currentStates)
            state.movieOff();
    }

    @Override
    public void resume() {
        for(PowerStateOn state : currentStates)
            state.resume();
    }
}
