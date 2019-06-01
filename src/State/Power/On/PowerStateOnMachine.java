package State.Power.On;

import State.IState;
import State.MovieDownloader;
import State.Power.On.AccountType.*;
import State.Power.On.Download.*;
import State.Power.On.Queue.*;
import State.Power.On.Watch.*;
import javafx.beans.value.ObservableDoubleValue;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class PowerStateOnMachine extends APowerComplexState {

    private int points;
    private double space_available;
    private Queue<MyFile> queue;

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

        space_available=100;
        points=1;
        queue=new LinkedBlockingQueue<>();

        this.watchStateIdle = new WatchStateIdle(this);
        this.watchStatePause = new WatchStatePause(this);
        this.watchStateWatch = new WatchStateWatch(this);
        setCurrentWatchState(watchStateIdle);

        this.downloadStateDownload = new DownloadStateDownload(this);
        this.downloadStateFirstCheck = new DownloadStateFirstCheck(this);
        this.downloadStateSecondCheck = new DownloadStateSecondCheck(this);
        this.downloadStateIdle = new DownloadStateIdle(this);
        this.downloadStatePause = new DownloadStatePause(this);
        this.downloadStateRepair = new DownloadStateRepair(this);
        this.currentDownloadState = downloadStateIdle;
        setCurrentDownloadState(downloadStateIdle);

        this.accountTypeStateAdvanced = new AccountTypeStateAdvanced(this);
        this.accountTypeStateProfessional = new AccountTypeStateProfessional(this);
        this.accountTypeStateStarter = new AccountTypeStateStarter(this);
        setCurrentAccountTypeState(accountTypeStateStarter);

        this.queueStateManager = new QueueStateManager(this);
        setCurrentQueueState(queueStateManager);
    }


    public void setCurrentWatchState(AWatchState state){
        removeCurrentState(currentWatchState);
        currentWatchState = state;
        currentStates.add(currentWatchState);
        currentWatchState.enterState();

    }

    public void setCurrentDownloadState(ADownloadState state){
        removeCurrentState(currentDownloadState);
        currentDownloadState = state;
        currentStates.add(currentDownloadState);
        currentDownloadState.enterState();

    }

    public void setCurrentAccountTypeState(AAccountTypeState state){
        removeCurrentState(currentAccountTypeState);
        currentAccountTypeState = state;
        currentStates.add(currentAccountTypeState);
        currentAccountTypeState.enterState();

    }

    public void setCurrentQueueState(AQueueState state){
        removeCurrentState(currentQueueState);
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

    public int getPoints() {
        return points;
    }

    public void addPoint(){
        points++;
        currentAccountTypeState.pointsChanged();
    }

    public void removePoint(){
        points=Math.max(0,points-1);
        currentAccountTypeState.pointsChanged();
    }

    public void getNext(){
        if(queue.size()>0)
            downloadStateDownload.setFile(queue.remove());
        else
            downloadStateDownload.setFile(null);
    }

    public void addFile(MyFile file){
        queue.add(file);
    }

    public double getSpace_available() {
        return space_available;
    }

    public void setSpace_available(int space_available) {
        this.space_available = space_available;
    }

    public double getCurrentFileSize() {
        return downloadStateDownload.getFileSize();
    }

    public void setSpeed(double speed){
        downloadStateDownload.setSpeed(speed);
    }

    public double getProgress(){
        return downloadStateDownload.getProgress();
    }

    public void resetTime(){
        watchStateWatch.resetTime();
    }
}
