package uff.ic.lleme.tcc00175.aulas.exercicios.calculadora.decorator;

import uff.ic.lleme.tcc00175.aulas.exercicios.calculadora.chainOfResponsability.FragmentadorVariavel;
import uff.ic.lleme.tcc00175.aulas.exercicios.calculadora.chainOfResponsability.FragmentadorLiteral;
import uff.ic.lleme.tcc00175.aulas.exercicios.calculadora.chainOfResponsability.FragmentadorDeExpressao;

public class InterpretadorBasico extends InterpretadorDeExpressao {

    public InterpretadorBasico() {
        FragmentadorDeExpressao f1;
        FragmentadorDeExpressao f2;
        f1 = new FragmentadorLiteral();
        cadeiaDeFragmentadores = f1;
        f2 = new FragmentadorVariavel();
        f1.proximo = f2;
    }

    @Override
    public String fragmentar(String expressao) throws Exception {
        return cadeiaDeFragmentadores.extrairSimbolo(expressao);
    }
}
