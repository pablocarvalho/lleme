package exercicios.calculadora.command;

import exercicios.calculadora.mediator.MediadorDeAlteracao;
import exercicios.calculadora.memento.Originator;

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
