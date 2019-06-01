package State.Power.On;

import State.MovieDownloader;
import State.Power.On.AccountType.*;
import State.Power.On.Download.*;
import State.Power.On.Queue.*;
import State.Power.On.Watch.*;

public class PowerStateOnMachine extends IPowerComplexState {

    private IWatchState currentWatchState;
    private WatchStateIdle watchStateIdle;
    private WatchStatePause watchStatePause;
    private WatchStateWatch watchStateWatch;

    private IDownloadState currentDownloadState;
    private DownloadStateDownload downloadStateDownload;
    private DownloadStateFirstCheck downloadStateFirstCheck;
    private DownloadStateSecondCheck downloadStateSecondCheck;
    private DownloadStateIdle downloadStateIdle;
    private DownloadStatePause downloadStatePause;
    private DownloadStateRepair downloadStateRepair;

    private IAccountTypeState currentAccountTypeState;
    private AccountTypeStateAdvanced accountTypeStateAdvanced;
    private AccountTypeStateProfessional accountTypeStateProfessional;
    private AccountTypeStateStarter accountTypeStateStarter;

    private IQueueState currentQueueState;
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

    public void setCurrentWatchState(IWatchState state){
        currentStates.remove(currentWatchState);
        currentWatchState = state;
        currentStates.add(currentWatchState);
    }

    public void setCurrentDownloadState(IDownloadState state){
        currentStates.remove(currentDownloadState);
        currentDownloadState = state;
        currentStates.add(currentDownloadState);
    }

    public void setCurrentAccountTypeState(IAccountTypeState state){
        currentStates.remove(currentAccountTypeState);
        currentAccountTypeState = state;
        currentStates.add(currentAccountTypeState);
    }

    public void setCurrentQueueState(IQueueState state){
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

}
