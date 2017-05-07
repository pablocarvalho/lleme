package uff.ic.tcc00175.exercicios.temporizador.controller;

import uff.ic.tcc00175.exercicios.temporizador.model.Temporizador;

public class StartCommand extends CommandImpl {

    public StartCommand(Temporizador t) {
        super(t);
    }

    public void execute() {
        getReceiver().serviceStart();
    }
}
