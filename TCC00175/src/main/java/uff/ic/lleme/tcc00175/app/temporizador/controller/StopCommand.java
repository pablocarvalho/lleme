package uff.ic.lleme.tcc00175.app.temporizador.controller;

import uff.ic.lleme.tcc00175.app.temporizador.model.Temporizador;

public class StopCommand extends CommandImpl {

    public StopCommand(Temporizador t) {
        super(t);
    }

    public void execute() {
        getReceiver().serviceStop();
    }
}
