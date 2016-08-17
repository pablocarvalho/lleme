package exercicios.letreiro.view;

import exercicios.letreiro.model.Letreiro;
import exercicios.letreiro.model.mostrador1.Fabrica;
import exercicios.letreiro.view.Painel;

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
