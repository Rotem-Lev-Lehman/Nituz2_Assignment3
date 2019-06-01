package State.Power.On;

import State.Power.APowerState;
import State.Power.On.AccountType.*;
import State.Power.On.Download.*;
import State.Power.On.Queue.*;
import State.Power.On.Watch.*;

import java.util.ArrayList;
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

        this.watchStateIdle = new WatchStateIdle(this);
        this.watchStatePause = new WatchStatePause(this);
        this.watchStateWatch = new WatchStateWatch(this);
        this.currentWatchState = watchStateIdle;
        currentStates.add(currentWatchState);

        this.downloadStateDownload = new DownloadStateDownload(this);
        this.downloadStateFirstCheck = new DownloadStateFirstCheck(this);
        this.downloadStateSecondCheck = new DownloadStateSecondCheck(this);
        this.downloadStateIdle = new DownloadStateIdle(this);
        this.downloadStatePause = new DownloadStatePause(this);
        this.downloadStateRepair = new DownloadStateRepair(this);
        this.currentDownloadState = downloadStateIdle;
        currentStates.add(currentDownloadState);

        this.accountTypeStateAdvanced = new AccountTypeStateAdvanced(this);
        this.accountTypeStateProfessional = new AccountTypeStateProfessional(this);
        this.accountTypeStateStarter = new AccountTypeStateStarter(this);
        this.currentAccountTypeState = accountTypeStateStarter;
        currentStates.add(currentAccountTypeState);

        this.queueStateManager = new QueueStateManager(this);
        this.currentQueueState = queueStateManager;
        currentStates.add(currentQueueState);
    }

    public void setCurrentWatchState(AWatchState state){
        currentStates.remove(currentWatchState);
        currentWatchState = state;
        currentStates.add(currentWatchState);
    }

    public void setCurrentDownloadState(ADownloadState state){
        currentStates.remove(currentDownloadState);
        currentDownloadState = state;
        currentStates.add(currentDownloadState);
    }

    public void setCurrentAccountTypeState(AAccountTypeState state){
        currentStates.remove(currentAccountTypeState);
        currentAccountTypeState = state;
        currentStates.add(currentAccountTypeState);
    }

    public void setCurrentQueueState(AQueueState state){
        currentStates.remove(currentQueueState);
        currentQueueState = state;
        currentStates.add(currentQueueState);
    }

    public WatchStateIdle getWatchStateIdle() {
        return watchStateIdle;
    }

    public WatchStatePause getWatchStatePause() {
        return watchStatePause;
    }

    public WatchStateWatch getWatchStateWatch() {
        return watchStateWatch;
    }

    public DownloadStateDownload getDownloadStateDownload() {
        return downloadStateDownload;
    }

    public DownloadStateFirstCheck getDownloadStateFirstCheck() {
        return downloadStateFirstCheck;
    }

    public DownloadStateSecondCheck getDownloadStateSecondCheck() {
        return downloadStateSecondCheck;
    }

    public DownloadStateIdle getDownloadStateIdle() {
        return downloadStateIdle;
    }

    public DownloadStatePause getDownloadStatePause() {
        return downloadStatePause;
    }

    public DownloadStateRepair getDownloadStateRepair() {
        return downloadStateRepair;
    }

    public AccountTypeStateAdvanced getAccountTypeStateAdvanced() {
        return accountTypeStateAdvanced;
    }

    public AccountTypeStateProfessional getAccountTypeStateProfessional() {
        return accountTypeStateProfessional;
    }

    public AccountTypeStateStarter getAccountTypeStateStarter() {
        return accountTypeStateStarter;
    }

    public QueueStateManager getQueueStateManager() {
        return queueStateManager;
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
