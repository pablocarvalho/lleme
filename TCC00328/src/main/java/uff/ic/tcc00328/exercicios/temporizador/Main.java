package uff.ic.tcc00328.exercicios.temporizador;

import uff.ic.tcc00328.exercicios.temporizador.view.TelaPrincipal;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public abstract class Main {

    private static void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        TelaPrincipal.getInstance();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
