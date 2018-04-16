package uff.ic.lleme.tcc00175.aulas.exercicios.temporizador.controller;

import uff.ic.lleme.tcc00175.aulas.exercicios.temporizador.model.Temporizador;

public class StopCommand extends CommandImpl {

    public StopCommand(Temporizador t) {
        super(t);
    }

    public void execute() {
        getReceiver().serviceStop();
    }
}
