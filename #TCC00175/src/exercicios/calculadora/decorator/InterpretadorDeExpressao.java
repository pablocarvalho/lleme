package exercicios.calculadora.decorator;

import exercicios.calculadora.chainOfResponsability.FragmentadorDeExpressao;
import exercicios.calculadora.interpreter.RepresentacaoExpressao;

public abstract class InterpretadorDeExpressao {

    protected FragmentadorDeExpressao cadeiaDeFragmentadores = null;

    public RepresentacaoExpressao interpretar(String expressao) throws Exception {
        String expressaoAnterior;
        do {
            expressaoAnterior = expressao;
            expressao = fragmentar(expressao);
        } while (expressao != null && !expressao.equals(expressaoAnterior));
        return FragmentadorDeExpressao.getPilha().peek();
    }

    public abstract String fragmentar(String expressao) throws Exception;
}
