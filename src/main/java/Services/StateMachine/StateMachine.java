package Services.StateMachine;
import Services.StateMachine.States.*;

public class StateMachine {
    public BaseState currentState;

    public void SwitchState(BaseState newState) {
        if (currentState != null) {
            currentState.exit();
        }
        currentState = newState;
        currentState.start();
    }
}
