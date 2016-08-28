package uff.ic.tcc00328.exercicios.temporizador.controller;

import uff.ic.tcc00328.exercicios.temporizador.model.Temporizador;

public class StopCommand extends CommandImpl {

    public StopCommand(Temporizador t) {
        super(t);
    }

    public void execute() {
        getReceiver().serviceStop();
    }
}
