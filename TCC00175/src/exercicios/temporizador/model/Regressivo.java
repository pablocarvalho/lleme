package exercicios.temporizador.model;

import java.util.Calendar;

public class Regressivo extends Temporizador {

    public Regressivo() {
        super();
        setNomeThread("Temporizador");
        setIntervaloThread(1000);
        serviceReset();
    }

    public void serviceReset() {
        long dif = 0;
        setAgora(Calendar.getInstance());
        getInicio().setTimeInMillis(getAgora().getTimeInMillis());
        getAgora().add(Calendar.MINUTE, 1);
        getTempoParcial().setTimeInMillis(
                getAgora().getTimeInMillis() - getInicio().getTimeInMillis()
                - getTempoParcial().getTimeZone().getOffset(0));
        getAgora().setTimeInMillis(getInicio().getTimeInMillis());
        dif = getTempoParcial().getTimeInMillis()
                - (getAgora().getTimeInMillis() - getInicio().getTimeInMillis());
        getTempo().setTimeInMillis(
                dif < -getTempoParcial().getTimeZone().getOffset(0) ? 0 - getTempoParcial().getTimeZone().getOffset(0)
                : dif);
        notifyObservers();
    }

    protected void updateTempo() {
        long dif = 0;
        if (getClockThread() != null)
            setAgora(Calendar.getInstance());
        dif = getTempoParcial().getTimeInMillis()
                - (getAgora().getTimeInMillis() - getInicio().getTimeInMillis());
        getTempo().setTimeInMillis(
                dif < -getTempoParcial().getTimeZone().getOffset(0) ? 0 - getTempoParcial().getTimeZone().getOffset(0)
                : dif);
    }
}
