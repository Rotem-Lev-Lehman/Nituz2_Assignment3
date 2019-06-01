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
        currentPowerState = powerStateOff;
        currentStates.add(currentPowerState);

        networkStateOff = new NetworkStateOff(this);
        networkStateOn = new NetworkStateOn(this);
        currentNetworkState = networkStateOff;
        currentStates.add(currentNetworkState);
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
        currentStates.remove(currentPowerState);
        currentPowerState.exitState();
        this.currentPowerState = state;
        currentStates.add(currentPowerState);
        currentPowerState.enterState();
    }

    public void setCurrentNetworkState(ANetworkState state) {
        currentStates.remove(currentNetworkState);
        currentNetworkState.exitState();
        this.currentNetworkState = state;
        currentStates.add(currentNetworkState);
        currentNetworkState.enterState();
    }


    @Override
    public void enterState() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void exitState() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getStateName() {
        throw new UnsupportedOperationException();
    }

    public IPowerState getCurrentPowerState() {
        return currentPowerState;
    }

    public ANetworkState getCurrentNetworkState() {
        return currentNetworkState;
    }
}
