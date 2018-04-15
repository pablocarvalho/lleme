package uff.ic.lleme.tcc00175.exercicios.temporizador.model;

import java.util.Calendar;

public class Relogio extends Temporizador {

    public Relogio() {
        super();
        setNomeThread("Rel�gio");
        setIntervaloThread(1000);
        serviceStart();
    }

    protected void updateTempo() {
        setTempo(Calendar.getInstance());
    }
}
