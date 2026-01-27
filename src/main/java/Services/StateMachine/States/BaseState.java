package Services.StateMachine.States;

public abstract class BaseState {
    public abstract void start(); // inicia o estado
    public abstract void update(); // atualiza o estado a cada frame
    public abstract void exit(); // limpa o estado ao sair

}
