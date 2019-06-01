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
        this.currentPowerState = state;
        currentStates.add(currentPowerState);
    }

    public void setCurrentNetworkState(ANetworkState state) {
        currentStates.remove(currentNetworkState);
        this.currentNetworkState = state;
        currentStates.add(currentNetworkState);    }
}
