package uff.ic.lleme.tcc00175.aulas.exercicios.calculadora.command;

import uff.ic.lleme.tcc00175.aulas.exercicios.calculadora.mediator.MediadorDeAlteracao;
import uff.ic.lleme.tcc00175.aulas.exercicios.calculadora.memento.Memento;
import uff.ic.lleme.tcc00175.aulas.exercicios.calculadora.memento.Originator;

public abstract class Command {

    protected MediadorDeAlteracao mediador;
    protected Originator originator;
    protected Memento mementoMediador;
    protected Memento mementoOriginator;

    public Command(MediadorDeAlteracao mediador, Originator originator) throws CloneNotSupportedException {
        this.mediador = mediador;
        this.originator = originator;
    }

    public void execute() throws CloneNotSupportedException, Exception {
        mementoMediador = mediador.createMemento();
        mementoOriginator = originator.createMemento();
    }

    public void desfazer() {
        mediador.setMemento(mementoMediador);
        originator.setMemento(mementoOriginator);
    }
}
