package State.Power.On.Queue;

import State.Power.On.MyFile;
import State.Power.On.PowerStateOnMachine;

public class QueueStateManager extends AQueueState {
    public QueueStateManager(PowerStateOnMachine powerStateOnMachine) {
        super(powerStateOnMachine);
    }

    @Override
    public String getStateName() {
        return "Queue_Manager";
    }

    @Override
    public void fileRequest(MyFile file) {
        powerStateOnMachine.addFile(file);
    }
}
