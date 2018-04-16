package uff.ic.lleme.tcc00175.app.temporizador.view;

import java.awt.Button;
import java.awt.event.ActionListener;

public abstract class Botao extends Button implements ActionListener {

    public Botao(String nome) {
        super(nome);
        addActionListener(this);
    }
}