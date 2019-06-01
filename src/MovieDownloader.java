import State.Network.*;
import State.Power.APowerState;
import State.Power.Off.*;
import State.Power.On.*;

public class MovieDownloader {

    private APowerState currentPowerState;
    private PowerStateOff powerStateOff;
    private PowerStateOn powerStateOn;

    private ANetworkState currentNetworkState;
    private NetworkStateOff networkStateOff;
    private NetworkStateOn networkStateOn;

}
