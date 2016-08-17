package exercicios.temporizador;

import exercicios.temporizador.view.TelaPrincipal;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public abstract class Temporizador {

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
