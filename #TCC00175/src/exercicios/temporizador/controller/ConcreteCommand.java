package exercicios.temporizador.controller;

public class ConcreteCommand extends Command {

    public void execute() {
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    private Receiver lnkReceiver = null;
    private int state;
}
