package uff.ic.lleme.tcc00175.exercicios.calculadora.decorator;

import uff.ic.lleme.tcc00175.exercicios.calculadora.chainOfResponsability.FragmentadorDeExpressao;
import uff.ic.lleme.tcc00175.exercicios.calculadora.chainOfResponsability.FragmentadorDivisao;
import uff.ic.lleme.tcc00175.exercicios.calculadora.chainOfResponsability.FragmentadorMultiplicacao;
import uff.ic.lleme.tcc00175.exercicios.calculadora.chainOfResponsability.FragmentadorSoma;
import uff.ic.lleme.tcc00175.exercicios.calculadora.chainOfResponsability.FragmentadorSubtracao;

public class InterpretadorAritmetico extends Decorador {

    public InterpretadorAritmetico(InterpretadorDeExpressao componente) {
        super(componente);
        FragmentadorDeExpressao f1;
        FragmentadorDeExpressao f2;
        f1 = new FragmentadorSoma();
        this.cadeiaDeFragmentadores = f1;
        f2 = new FragmentadorSubtracao();
        f1.proximo = f2;
        f1 = f2;
        f2 = new FragmentadorMultiplicacao();
        f1.proximo = f2;
        f1 = f2;
        f2 = new FragmentadorDivisao();
        f1.proximo = f2;
    }

    @Override
    public String fragmentar(String expressao) throws Exception {
        expressao = getComponent().fragmentar(expressao);
        return cadeiaDeFragmentadores.extrairSimbolo(expressao);
    }
}
