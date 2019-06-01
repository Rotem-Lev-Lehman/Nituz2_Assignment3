package State.Power.On;

import State.MovieDownloader;
import State.Power.On.AccountType.*;
import State.Power.On.Download.*;
import State.Power.On.Queue.*;
import State.Power.On.Watch.*;

import java.util.Queue;

public class PowerStateOnMachine extends APowerComplexState {

    private int points=0;
    private Queue<MyFile> queue;
    private double speed;

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

    public PowerStateOnMachine(MovieDownloader movieDownloader) {

        super(movieDownloader);

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
        currentWatchState.exitState();
        currentWatchState = state;
        currentStates.add(currentWatchState);
        currentWatchState.enterState();

    }

    public void setCurrentDownloadState(ADownloadState state){
        currentStates.remove(currentDownloadState);
        currentDownloadState.exitState();
        currentDownloadState = state;
        currentStates.add(currentDownloadState);
        currentDownloadState.enterState();

    }

    public void setCurrentAccountTypeState(AAccountTypeState state){
        currentStates.remove(currentAccountTypeState);
        currentAccountTypeState.exitState();
        currentAccountTypeState = state;
        currentStates.add(currentAccountTypeState);
        currentAccountTypeState.enterState();

    }

    public void setCurrentQueueState(AQueueState state){
        currentStates.remove(currentQueueState);
        currentQueueState.exitState();
        currentQueueState = state;
        currentStates.add(currentQueueState);
        currentQueueState.enterState();
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
    public void enterState() {

    }

    @Override
    public void exitState() {

    }

    @Override
    public String getStateName() {
        return "On";
    }

    public AWatchState getCurrentWatchState() {
        return currentWatchState;
    }

    public ADownloadState getCurrentDownloadState() {
        return currentDownloadState;
    }

    public AAccountTypeState getCurrentAccountTypeState() {
        return currentAccountTypeState;
    }

    public AQueueState getCurrentQueueState() {
        return currentQueueState;
    }

    public void turnOff() {
        super.turnOff();
        movieDownloader.setCurrentPowerState(movieDownloader.getPowerStateOff());
    }
}
