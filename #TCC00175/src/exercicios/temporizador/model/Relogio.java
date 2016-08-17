package exercicios.temporizador.model;

import java.util.Calendar;

public class Relogio extends Temporizador {

    public Relogio() {
        super();
        setNomeThread("Relógio");
        setIntervaloThread(1000);
        serviceStart();
    }

    protected void updateTempo() {
        setTempo(Calendar.getInstance());
    }
}
