package uff.ic.lleme.controller;

import uff.ic.lleme.model.Temporizador;

public class StopCommand extends CommandImpl {

    public StopCommand(Temporizador t) {
        super(t);
    }

    public void execute() {
        getReceiver().serviceStop();
    }
}
