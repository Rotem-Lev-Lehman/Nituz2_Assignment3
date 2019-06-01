package State;

import State.Power.On.MyFile;

public interface IState {

    String getStateName();
    default void enterState(){
        printEnter();
    }
    default void exitState(){
        printExit();
    }
    default void printEnter(){
        System.out.println("enter " + getStateName() + " state");
    }
    default void printExit(){
        System.out.println("exit " + getStateName() + " state");
    }

    void turnOn();
    void turnOff();
    void internetOn();
    void internetOff();
    void fileRequest(MyFile file);
    void downloadAborted();
    void downloadError();
    void errorFixed();
    void movieOn();
    void restartMovie();
    void holdMovie();
    void movieOff();
    void resume();

}
