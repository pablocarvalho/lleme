package exercicios.temporizador.model;

import java.util.Calendar;

public abstract class Temporizador extends SubjectImpl implements Runnable {

    private Calendar agora = null;
    private Calendar inicio = null;
    private Calendar tempo = null;
    private Thread clockThread = null;
    private Calendar tempoParcial = null;
    private String nomeThread;
    private int intervaloThread;

    public Temporizador() {
        setInicio(Calendar.getInstance());
        setAgora(Calendar.getInstance());
        setTempo(Calendar.getInstance());
        setTempoParcial(Calendar.getInstance());
    }

    public void run() {
        Thread myThread = Thread.currentThread();
        while (getClockThread() == myThread) {
            updateTempo();
            notifyObservers();
            try {
                Thread.sleep(intervaloThread);
            } catch (InterruptedException e) {
                // TODO
            }
        }
    }

    public void serviceStart() {
        setInicio(Calendar.getInstance());
        if (clockThread == null) {
            setClockThread(new Thread(this, nomeThread));
            getClockThread().start();
            notifyObservers();
        }
    }

    public void serviceStop() {
        getTempoParcial().setTimeInMillis(getTempo().getTimeInMillis());
        setInicio(Calendar.getInstance());
        setClockThread(null);
        notifyObservers();
        System.gc();
    }

    public void serviceReset() {
        // TODO
    }

    protected Calendar getAgora() {
        return this.agora;
    }

    protected Calendar getInicio() {
        return this.inicio;
    }

    public Calendar getTempo() {
        return this.tempo;
    }

    protected Calendar getTempoParcial() {
        return this.tempoParcial;
    }

    abstract void updateTempo();

    public Thread getClockThread() {
        return this.clockThread;
    }

    protected void setClockThread(Thread clockThread) {
        this.clockThread = clockThread;
    }

    protected int getIntervaloThread() {
        return intervaloThread;
    }

    protected void setIntervaloThread(int intervaloThread) {
        this.intervaloThread = intervaloThread;
    }

    protected String getNomeThread() {
        return this.nomeThread;
    }

    protected void setNomeThread(String nomeThread) {
        this.nomeThread = nomeThread;
    }

    protected void setAgora(Calendar agora) {
        this.agora = agora;
    }

    protected void setInicio(Calendar inicio) {
        this.inicio = inicio;
    }

    protected void setTempo(Calendar tempo) {
        this.tempo = tempo;
    }

    protected void setTempoParcial(Calendar tempoParcial) {
        this.tempoParcial = tempoParcial;
    }
}
