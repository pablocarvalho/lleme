package exercicios.letreiro.controller;

import exercicios.letreiro.model.Letreiro;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadLigarLetreiro implements Runnable {

    private Letreiro letreiro = null;

    public ThreadLigarLetreiro(Letreiro letreiro) {
        this.letreiro = letreiro;
    }

    @Override
    public void run() {
        while (true)
            try {
                letreiro.avisarObservador();
                Thread.sleep(200);
                letreiro.posInicialMsg++;
            } catch (InterruptedException ex) {
                Logger.getLogger(Letreiro.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
