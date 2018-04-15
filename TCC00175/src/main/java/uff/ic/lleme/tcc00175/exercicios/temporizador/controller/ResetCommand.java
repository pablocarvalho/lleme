package uff.ic.lleme.tcc00175.exercicios.temporizador.controller;

import uff.ic.lleme.tcc00175.exercicios.temporizador.model.Temporizador;

public class ResetCommand extends CommandImpl {

    public void execute() {
        getReceiver().serviceReset();
    }

    public ResetCommand(Temporizador t) {
        super(t);
    }
}
