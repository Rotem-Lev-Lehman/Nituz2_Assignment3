package State;

public interface IState {

    void enterState();
    void exitState();
    void printExit();
    void printEnter();
    String getStateName();

    void turnOn();
    void turnOff();
    void internetOn();
    void internetOff();
    void fileRequest();
    void downloadAborted();
    void downloadError();
    void errorFixed();
    void movieOn();
    void restartMovie();
    void holdMovie();
    void movieOff();
    void resume();

}
