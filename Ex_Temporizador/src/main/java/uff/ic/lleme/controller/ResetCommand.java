package uff.ic.lleme.controller;

import uff.ic.lleme.model.Temporizador;

public class ResetCommand extends CommandImpl {

    public void execute() {
        getReceiver().serviceReset();
    }

    public ResetCommand(Temporizador t) {
        super(t);
    }
}
