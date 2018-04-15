package uff.ic.lleme.tcc00175.aulas.exercicios.temporizador.controller;

import uff.ic.lleme.tcc00175.aulas.exercicios.temporizador.model.Temporizador;

public class StartCommand extends CommandImpl {

    public StartCommand(Temporizador t) {
        super(t);
    }

    public void execute() {
        getReceiver().serviceStart();
    }
}
