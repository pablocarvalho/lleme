package exercicios.temporizador.view;

import javax.swing.JFrame;

public abstract class Tela extends JFrame {

    public Tela(String nome) {
        super(nome);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                evt.getNewState();
                exitForm();
            }

            public void windowClosed(java.awt.event.WindowEvent evt) {
                evt.getNewState();
                System.gc();
            }
        });
    }

    public void initComponents() {
        setVisible(true);
    }

    public void exitForm() {
        System.gc();
    }
}
