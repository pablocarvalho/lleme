package exercicios.temporizador.model;

import java.util.Calendar;

public class Cronometro extends Temporizador {

    public Cronometro() {
        super();
        setNomeThread("Cronometro");
        setIntervaloThread(10);
        serviceReset();
    }

    public void serviceReset() {
        setInicio(Calendar.getInstance());
        getAgora().setTimeInMillis(getInicio().getTimeInMillis());
        getTempoParcial().setTimeInMillis(
                0 - getTempoParcial().getTimeZone().getOffset(0));
        getTempo().setTimeInMillis(
                getTempoParcial().getTimeInMillis()
                + getAgora().getTimeInMillis()
                - getInicio().getTimeInMillis());
        notifyObservers();
    }

    protected void updateTempo() {
        if (getClockThread() != null)
            setAgora(Calendar.getInstance());
        getTempo().setTimeInMillis(
                getTempoParcial().getTimeInMillis()
                + getAgora().getTimeInMillis()
                - getInicio().getTimeInMillis());
    }
}
