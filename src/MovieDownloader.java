import State.Network.*;
import State.Power.APowerState;
import State.Power.Off.*;
import State.Power.On.*;

public class MovieDownloader {

    private APowerState currentPowerState;
    private PowerStateOff powerStateOff;
    private PowerStateOnMachine powerStateOnMachine;

    private ANetworkState currentNetworkState;
    private NetworkStateOff networkStateOff;
    private NetworkStateOn networkStateOn;

}
