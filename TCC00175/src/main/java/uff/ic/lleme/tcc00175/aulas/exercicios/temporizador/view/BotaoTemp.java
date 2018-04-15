package uff.ic.lleme.tcc00175.aulas.exercicios.temporizador.view;

import uff.ic.lleme.tcc00175.aulas.exercicios.temporizador.model.Temporizador;

public abstract class BotaoTemp extends Botao implements Element {

    private Temporizador mySubjectTemporizador;

    public BotaoTemp(String nome, Temporizador temporizador) {
        super(nome);
        this.mySubjectTemporizador = temporizador;
    }

    public Temporizador getMySubjectTemporizador() {
        return mySubjectTemporizador;
    }

    public void setMySubjectTemporizador(Temporizador temporizador) {
        this.mySubjectTemporizador = temporizador;
    }
}
