package State;

import State.Network.*;
import State.Power.IPowerState;
import State.Power.Off.*;
import State.Power.On.*;

public class MovieDownloader extends AComplexState{

    private IPowerState currentPowerState;
    private PowerStateOff powerStateOff;
    private PowerStateOnMachine powerStateOnMachine;

    private ANetworkState currentNetworkState;
    private NetworkStateOff networkStateOff;
    private NetworkStateOn networkStateOn;

    public MovieDownloader() {
        super();
        powerStateOnMachine = new PowerStateOnMachine(this);
        powerStateOff = new PowerStateOff(this);
        setCurrentPowerState(powerStateOff);

        networkStateOff = new NetworkStateOff(this);
        networkStateOn = new NetworkStateOn(this);
        setCurrentNetworkState(networkStateOff);
    }

    public PowerStateOff getPowerStateOff() {
        return powerStateOff;
    }

    public PowerStateOnMachine getPowerStateOnMachine() {
        return powerStateOnMachine;
    }

    public NetworkStateOff getNetworkStateOff() {
        return networkStateOff;
    }

    public NetworkStateOn getNetworkStateOn() {
        return networkStateOn;
    }

    public void setCurrentPowerState(IPowerState state) {
        removeCurrentState(currentPowerState);
        this.currentPowerState = state;
        currentStates.add(currentPowerState);
        currentPowerState.enterState();
    }

    public void setCurrentNetworkState(ANetworkState state) {
        removeCurrentState(currentNetworkState);
        this.currentNetworkState = state;
        currentStates.add(currentNetworkState);
        currentNetworkState.enterState();
    }


    @Override
    public void exitState() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getStateName() {
        return "Movie_Downloader";
    }

    public IPowerState getCurrentPowerState() {
        return currentPowerState;
    }

    public ANetworkState getCurrentNetworkState() {
        return currentNetworkState;
    }

    public double getSpaceLeft() {
        return powerStateOnMachine.getSpaceAvailable();
    }

    public void addSpace(double space2Add) {
        powerStateOnMachine.addSpace(space2Add);
    }

    public boolean isOn() {
        return currentPowerState==powerStateOnMachine;
    }

    public double getSpeed() {
        return powerStateOnMachine.getSpeed();
    }

    public int getPoints() {
        return powerStateOnMachine.getPoints();
    }

    public int getQueueSize() {
        return powerStateOnMachine.getQueueSize();
    }
}
