package uff.ic.lleme.controller;

import uff.ic.lleme.model.Temporizador;

public class StartCommand extends CommandImpl {

    public StartCommand(Temporizador t) {
        super(t);
    }

    public void execute() {
        getReceiver().serviceStart();
    }
}
