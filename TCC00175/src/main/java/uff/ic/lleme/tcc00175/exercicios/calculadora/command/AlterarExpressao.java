package uff.ic.lleme.tcc00175.exercicios.calculadora.command;

import uff.ic.lleme.tcc00175.exercicios.calculadora.mediator.MediadorDeAlteracao;
import uff.ic.lleme.tcc00175.exercicios.calculadora.memento.Originator;

public class AlterarExpressao extends Command {

    private String expressao;

    public AlterarExpressao(String expressao, MediadorDeAlteracao mediador, Originator originator) throws CloneNotSupportedException {
        super(mediador, originator);
        this.expressao = expressao;
    }

    public void execute() throws CloneNotSupportedException, Exception {
        super.execute();
        mediador.setExpressaoStr(expressao);
    }
}
