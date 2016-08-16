package exercicios.calculadora.chainOfResponsability;

import exercicios.calculadora.interpreter.RepresentacaoExpressao;

import java.util.Stack;

public abstract class FragmentadorDeExpressao {

    private static Stack<RepresentacaoExpressao> pilha = new Stack<RepresentacaoExpressao>();
    public FragmentadorDeExpressao proximo = null;

    public static Stack<RepresentacaoExpressao> getPilha() {
        return pilha;
    }

    public abstract String extrairSimbolo(String expressaoStr) throws Exception;
}
