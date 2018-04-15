package uff.ic.lleme.tcc00328.exercicios.letreiro.view;

import uff.ic.lleme.tcc00328.exercicios.letreiro.model.Letreiro;
import uff.ic.lleme.tcc00328.exercicios.letreiro.model.mostrador1.Fabrica;
import uff.ic.lleme.tcc00328.exercicios.letreiro.view.Painel;

public class ThreadCriarPainelELetreiro implements Runnable {

    @Override
    public void run() {
        // Criar janela do letreiro
        Painel dialog = new Painel(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        // Criar Letreiro
        Letreiro letreiro = new Letreiro((byte) 20, new Fabrica(), dialog);
        letreiro.atribuirMensagem("Luiz Andre");
        letreiro.ligar();
        dialog.setVisible(true);
    }
}
