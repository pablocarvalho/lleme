package uff.ic.tcc00175.exercicios.temporizador.controller;

import uff.ic.tcc00175.exercicios.temporizador.model.Temporizador;

public abstract class CommandImpl extends Command {

    public CommandImpl(Temporizador t) {
        super();
        receiver = t;
    }
    private Temporizador receiver = null;

    public Temporizador getReceiver() {
        return receiver;
    }
}
