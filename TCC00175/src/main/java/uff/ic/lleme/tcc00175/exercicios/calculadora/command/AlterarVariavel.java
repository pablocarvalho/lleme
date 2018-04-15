package uff.ic.lleme.tcc00175.exercicios.calculadora.command;

import uff.ic.lleme.tcc00175.exercicios.calculadora.command.Command;
import uff.ic.lleme.tcc00175.exercicios.calculadora.mediator.MediadorDeAlteracao;
import uff.ic.lleme.tcc00175.exercicios.calculadora.memento.Originator;

public class AlterarVariavel extends Command {

    private String variavel;
    private Double valor;

    public AlterarVariavel(String variavel, Double valor, MediadorDeAlteracao mediador, Originator originator) throws CloneNotSupportedException {
        super(mediador, originator);
        this.variavel = variavel;
        this.valor = valor;
    }

    @Override
    public void execute() throws CloneNotSupportedException, Exception {
        super.execute();
        mediador.setVar(variavel, valor);
    }
}
